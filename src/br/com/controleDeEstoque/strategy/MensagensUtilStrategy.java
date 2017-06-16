/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.strategy;

import java.util.ResourceBundle;

/**
 *
 * @author Onismar
 */
public class MensagensUtilStrategy {

    private static final String FILE_NAME = "br.com.map.config/mensagens";
    public static final String MSG_ERRO_SALVAR = "msg_erro_salvar";
    public static final String MSG_SUCESSO_SALVAR = "msg_sucesso_salvar";
    public static final String MSG_SELECIONE = "msg_selecione";
    public static final String MSG_REMOVER = "msg_remover";
    public static final String MSG_EDITADO = "msg_editado";
    public static final String MSG_ALTERAR = "msg_alterar";
    
    private static ResourceBundle bundle;
    
    static {
        bundle = ResourceBundle.getBundle(FILE_NAME);
    }
    
    public static String getValor(String chave){
        return bundle.getString(chave);
    }
    
    public static String getValor(String chave, String valor){
        return String.format(bundle.getString(chave), valor);
    }
    
    
}
