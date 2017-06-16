/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.dao;

import br.com.controleDeEstoque.commom.dao.GenericDAO;
import br.com.controleDeEstoque.util.PersistenceUtil;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;

import br.com.controleDeEstoque.model.Funcionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Onismar
 */
public class FuncionarioDAO extends GenericDAO<Funcionario> implements IFuncionarioDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;

    @Override
    public void modificaStatus(Funcionario f, boolean status) throws ExceptionDAO {
        
        manager = PersistenceUtil.getInstance();
        //manager = this.getEntityManager();
        f.setStatus(status);
        manager.merge(f);
    }

    @Override
    public List<Funcionario> autorizacaoDesconto(boolean status) throws ExceptionDAO {
        List<Funcionario> lista = null;
        
        manager = PersistenceUtil.getInstance();
        //manager = this.getEntityManager();
        Criteria criteria = this.getCriteria();
        criteria.add(Restrictions.eq("autorizarDesconto", status));
        lista = criteria.list();
        return lista;
       
        
    }

    @Override
    public List<Funcionario> statusFuncionario(boolean status) throws ExceptionDAO {
        List<Funcionario> lista = null;
        
        manager = PersistenceUtil.getInstance();
        //manager = this.getEntityManager();
        Criteria criteria = this.getCriteria();
        criteria.add(Restrictions.eq("status", status));
        lista = criteria.list();
        return lista;
    }

    @Override
    public Funcionario retornaFuncionario(String cpf) throws ExceptionDAO {
        Funcionario f = null;
        
        manager = PersistenceUtil.getInstance();
        //manager = this.getEntityManager();
        Criteria criteria = this.getCriteria();
        criteria.add(Restrictions.eq("cpf", cpf));
        f = (Funcionario) criteria.uniqueResult();
        return f;
    }

    @Override
    public Funcionario retornaFuncionarioPorLogin(String login) throws ExceptionDAO {
       Funcionario f = new Funcionario();
        
        manager = PersistenceUtil.getInstance();
        //manager = this.getEntityManager();
        Criteria criteria = this.getCriteria();
        criteria.add(Restrictions.eq("login", login));
        f = (Funcionario) criteria.uniqueResult();
        return f;
    }

}
