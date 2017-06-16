/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.util;

import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Alan Santos Diniz
 */
public class PersistenceUtil {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager manager;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("ControleDeEstoquePU");
    }

    private PersistenceUtil() {

    }

    public static EntityManager getInstance() {
       if (manager == null || !manager.isOpen()) {
            manager = entityManagerFactory.createEntityManager();
        }

        return manager;
    }

}
