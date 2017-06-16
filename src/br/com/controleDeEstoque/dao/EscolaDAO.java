/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.dao;

import br.com.controleDeEstoque.commom.dao.GenericDAO;
import br.com.controleDeEstoque.util.PersistenceUtil;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.facade.Facade;
import br.com.controleDeEstoque.model.Escola;

import com.sun.jndi.toolkit.url.GenericURLDirContext;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EscolaDAO extends GenericDAO<Escola> implements IEscolaDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
  
    @Override
    public Escola getporNome(String nome) throws ExceptionDAO {
        Escola p = null;
        
        manager = PersistenceUtil.getInstance();
        //manager = getEntityManager();
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("nome", nome));
        p = (Escola) criteria.uniqueResult();

        return p;
    }

  

}
