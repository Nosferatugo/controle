/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.commom.dao;

import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;

/**
 *
 * @author Onismar
 */
public interface IGenegicDAO<T> {
    
    public void salvar(T t) throws ExceptionDAO;
    public void atualizar(T t) throws ExceptionDAO;
    public T getById (Long id) throws ExceptionDAO;
    public List<T> getTodos() throws ExceptionDAO;
     public List<T> getTodosGenerico(T t) throws ExceptionDAO;
    public EntityManager getEntityManager() throws ExceptionDAO;
    public Criteria getCriteria() throws ExceptionDAO;
    
}
