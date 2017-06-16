/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.enuns.ComposicaoProduto;
import br.com.controleDeEstoque.enuns.TipoProduto;
import br.com.controleDeEstoque.model.Fornecedor;
import br.com.controleDeEstoque.model.Produto;
import java.util.List;

/**
 *
 * @author Onismar
 */
public interface IProdutoBusiness {

    public void salvar(Produto p) throws ExceptionDAO;

    public void atualizar(Produto p) throws ExceptionDAO;

    public Produto getById(Long id) throws ExceptionDAO;

    public List<Produto> getTodos() throws ExceptionDAO;

    public List<Produto> getProdutoPorNome(String nome) throws ExceptionDAO;
    
    public void realizarCadastro(Long id, String descricao, TipoProduto tipoProduto, ComposicaoProduto composicaoProduto, String compraUnidade, String quantidade, Fornecedor f) throws ExceptionDAO;

}
