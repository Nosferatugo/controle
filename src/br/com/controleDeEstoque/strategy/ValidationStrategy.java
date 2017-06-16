/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.strategy;

import br.com.controleDeEstoque.commom.exception.ValidationException;
import br.com.controleDeEstoque.model.Fornecedor;
import br.com.controleDeEstoque.model.Funcionario;
import javax.swing.JOptionPane;

/**
 *
 * @author Onismar
 */
public class ValidationStrategy {

//    public static void validarNomeEntidade(Cliente cliente) throws ValidationException {
//        if (cliente.getNome().split(" ").length <= 1) {
//            throw new ValidationException("Erro ao validar nome");
//        }
//
//    }

    public Double validarDouble(String numero, String campo) {
        Double d = null;
        try {
            d = Double.parseDouble(numero);
            return d;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "valor do " + campo + " imposivel de validar,digite um número valido para o campo expecífico");
            e.printStackTrace();
        }
        return d;
    }

  

    public Boolean validaFornecedor(Fornecedor forne) {
        boolean verifica = true;
        if (forne.getCnpj().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Cnpj não informado");
            return verifica = false;
        }
        else if (forne.getNome().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Nome não informado");
            return verifica = false;
        }
        else if (forne.getEndereco().getBairro().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Bairro não informado");
            return verifica = false;
        }
        else if (forne.getEndereco().getCidade().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Cidade não informado");
            return verifica = false;

        }
        else if (forne.getEndereco().getCep().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Endereço não informado");
            return verifica = false;

        }
        else if (forne.getEndereco().getEstado().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Estado não informado");
            return verifica = false;

        }
        else if (forne.getEndereco().getNumero().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Numero da rua não informado");
            return verifica = false;

        }
        else if (forne.getEndereco().getRua().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Rua não informado");
            return verifica = false;

        } else {
            return verifica;
        }

    }

}
