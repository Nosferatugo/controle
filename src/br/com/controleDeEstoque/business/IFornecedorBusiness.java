/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.model.Fornecedor;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Onismar
 */
public interface IFornecedorBusiness {
    
    public void salvar(Fornecedor f) throws ExceptionDAO;
    
    public void atualizar(Fornecedor f) throws ExceptionDAO;
    
    public Fornecedor getById (Long id) throws ExceptionDAO;
    
    public List<Fornecedor> getTodos() throws ExceptionDAO;

//    public Boolean realizarCadastraFornecedor(Long id,String nome,String cnpj,String rua,String cep,String numero,String bairro,
//            String cidade,String estado)throws ExceptionDAO;
//    
    public void gerarTabelaFornecedor (JTable tabela) throws BusinessException;
    
    public void gerarTelaEditarFornecedor (Fornecedor f) throws BusinessException;
 
    
}
