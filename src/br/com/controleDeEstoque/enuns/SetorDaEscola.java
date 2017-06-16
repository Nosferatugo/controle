/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.enuns;

/**
 *
 * @author Onismar
 */
public enum SetorDaEscola {
    
    URBANO("Urbano"),
    RURAL("Rural");
    
    private String setorEscola;

    private SetorDaEscola(String setorDaEscola) {
        this.setorEscola = setorEscola;
    }

    public String getSetorVenda() {
        return setorEscola;
    }
    
    
    
    
}
