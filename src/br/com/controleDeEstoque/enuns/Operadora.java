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
public enum Operadora {
    
    
    TIM("Tim"),
    OI("Oi"),
    VIVO("Vivo"),
    CLARO("Claro");
    
    
    private String operadora;
    
    
    private Operadora (String operadora){
        this.operadora = operadora;
    }
    
    
}
