/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.dao;

import br.com.controleDeEstoque.commom.dao.IGenegicDAO;
import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.model.Escola;
import java.util.List;

public interface IEscolaDAO extends IGenegicDAO<Escola>{

    public Escola getporNome(String cpf) throws ExceptionDAO;
   
    
}
