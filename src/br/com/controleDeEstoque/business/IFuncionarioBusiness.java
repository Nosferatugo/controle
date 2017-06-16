/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.business;

import br.com.controleDeEstoque.commom.exception.BusinessException;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.enuns.EstadoCivil;
import br.com.controleDeEstoque.enuns.Sexo;
import br.com.controleDeEstoque.model.Contato;
import br.com.controleDeEstoque.model.Funcionario;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Onismar
 */
public interface IFuncionarioBusiness {

    public void salvar(Funcionario f) throws ExceptionDAO, BusinessException;

    public void atualizar(Funcionario f) throws ExceptionDAO, BusinessException;

    public Funcionario getById(Long id) throws ExceptionDAO, BusinessException;

    public List<Funcionario> getTodos() throws ExceptionDAO, BusinessException;

    public void modificaStatus(Funcionario f, boolean status) throws ExceptionDAO, BusinessException;

    public List<Funcionario> autorizacaoDesconto(boolean status) throws ExceptionDAO, BusinessException;

    public List<Funcionario> statusFuncionario(boolean status) throws ExceptionDAO, BusinessException;

    public Funcionario retornaFuncionario(String cpf) throws ExceptionDAO, BusinessException;

    public void realizarCadastroFuncionario(Long id,String nome, String cpf, String rg, String dataNascimento,
            String dataExpedicao, String orgaoEmissor, String rua, String numeroDaRua, String bairro, String cep,
            String cidade, String estado, List<Contato> listaContatos, Sexo sexo, EstadoCivil estadoSivil) throws ExceptionDAO, BusinessException;

    public void gerarTabelaFuncionario(JTable tabela) throws BusinessException;

    public void gerarTelaEditarFuncionario(Funcionario f) throws BusinessException;
    
    public Funcionario retornaFuncionarioPorLogin(String login) throws ExceptionDAO, BusinessException;
    
    public Boolean confirmaFuncionarioPorLogin(String login, String senha) throws ExceptionDAO, BusinessException;

}
