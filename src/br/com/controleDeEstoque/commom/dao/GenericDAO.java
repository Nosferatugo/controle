/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.commom.dao;

import br.com.controleDeEstoque.util.PersistenceUtil;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Onismar
 */
public class GenericDAO<T> implements IGenegicDAO<T> {

    private Class classe;
    private EntityManager manager;

    public GenericDAO() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void salvar(T t) throws ExceptionDAO {

        manager = PersistenceUtil.getInstance();
        
        try {
            
            manager.getTransaction().begin();
            manager.persist(t);
            manager.getTransaction().commit();
            
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao salvar no banco de dados");
        } finally {
            manager.close();
        }

    }

    @Override
    public void atualizar(T t) throws ExceptionDAO {
        manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(t);
            manager.getTransaction().commit();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao atualizar no banco de dados");
        } finally {
            manager.close();
        }

    }

    @Override
    public T getById(Long id) throws ExceptionDAO {
        T t = null;
        manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            criteria.add(Restrictions.eq("id", id));
            t = (T) criteria.uniqueResult();

        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao buscar por id no banco de dados");
        } finally {
            manager.close();
        }
        return t;

    }

    @Override
    public List<T> getTodos() throws ExceptionDAO {
        List<T> lista = null;
        manager = getEntityManager();
        try {
            System.out.println(manager);
            System.out.println(manager.getDelegate());
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            lista = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao buscar todos no banco de dados");
        } finally {
            manager.close();
        }
        return lista;

    }

    @Override
    public EntityManager getEntityManager() throws ExceptionDAO {
        try {
            manager = PersistenceUtil.getInstance();

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao criar EntityManager");
        }
        return manager;
    }

    @Override
    public Criteria getCriteria() throws ExceptionDAO {
        try {
            manager = PersistenceUtil.getInstance();
            return ((Session) manager.getDelegate()).createCriteria(classe);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao criar Criteria");
        }

    }

    @Override
    public List<T> getTodosGenerico(T t) throws ExceptionDAO {
        List<T> lista = null;
        manager = getEntityManager();
        try {
            Session session = (Session) manager.getDelegate();
            Criteria criteria = session.createCriteria(classe);
            lista = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionDAO("Erro ao buscar todos no banco de dados");
        } finally {
            manager.close();
        }
        return lista;

    }

}
