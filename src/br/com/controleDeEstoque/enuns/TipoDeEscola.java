/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.enuns;

/**
 *
 * @author Dell
 */
public enum TipoDeEscola {
    PRIMARIA("Primaria"),
    SECUNDARIA("Secundaria"),
    CRECHE("Creche"),
    PRIMARIA_SECUNDARIA("Primaria_Secundaria"),;
    
    private String tipoDeEscola;

    private TipoDeEscola(String tipoEscola) {
        this.tipoDeEscola = tipoEscola;
    }

    public String getTipoDeEscola() {
        return tipoDeEscola;
    }
}
