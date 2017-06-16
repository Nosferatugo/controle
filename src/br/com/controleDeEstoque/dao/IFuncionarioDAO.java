/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.dao;

import br.com.controleDeEstoque.commom.dao.IGenegicDAO;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.model.Funcionario;
import java.util.List;

/**
 *
 * @author Onismar
 */
public interface IFuncionarioDAO extends IGenegicDAO<Funcionario>{
    
    public void modificaStatus (Funcionario f, boolean status) throws ExceptionDAO;
    
    public List<Funcionario> autorizacaoDesconto (boolean status) throws ExceptionDAO;
    
    public List<Funcionario> statusFuncionario (boolean status) throws ExceptionDAO;
    
    public Funcionario retornaFuncionario (String cpf) throws ExceptionDAO;
   
    public Funcionario retornaFuncionarioPorLogin(String login) throws ExceptionDAO;
    
}
