/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.enuns;


public enum EstadoCivil {
    
    CASADO("Casado"),
    SOLTEIRO("Solteiro"),
    DIVORCIADO("Divorciado");
  
    
    
    private String estadoCivil;
    
    private EstadoCivil(String estado){
        this.estadoCivil = estado;
    }
    
    
}
