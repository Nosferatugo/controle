/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.main;

import br.com.controleDeEstoque.commom.exception.ExceptionDAO;
import br.com.controleDeEstoque.dao.FuncionarioDAO;
import br.com.controleDeEstoque.model.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ControleDeEstoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       FuncionarioDAO daof = new FuncionarioDAO();
       Funcionario f = new Funcionario();
       f.setNome("alan");
        try {
            daof.salvar(f);
        } catch (ExceptionDAO ex) {
            Logger.getLogger(ControleDeEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
