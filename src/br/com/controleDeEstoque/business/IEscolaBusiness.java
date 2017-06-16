/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.enuns.EstadoCivil;
import br.com.controleDeEstoque.enuns.Operadora;
import br.com.controleDeEstoque.enuns.Sexo;
import br.com.controleDeEstoque.enuns.TipoDeEscola;
import br.com.controleDeEstoque.model.Escola;
import br.com.controleDeEstoque.model.Contato;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Onismar
 */
public interface IEscolaBusiness {

    public void salvar(Escola e) throws BusinessException, ExceptionDAO;

    public void realizarCadastro(Long id, String nome,TipoDeEscola tipoEscola,String rua, String numeroDaRua, String bairro, String cep,
            String cidade, String estado, List<Contato> listaContatos) throws BusinessException, ExceptionDAO;

    public void atualizar(Escola e) throws BusinessException, ExceptionDAO;

    public Escola getById(Long id) throws BusinessException, ExceptionDAO;

    public List<Escola> getTodos() throws BusinessException, ExceptionDAO;

    public Escola getporNome(String nome) throws BusinessException, ExceptionDAO;

    public void gerarTabelaEscola (JTable tabela) throws BusinessException;
    
    public void gerarTelaEditarEscola (Escola e) throws BusinessException;

}
