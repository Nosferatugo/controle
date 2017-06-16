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
public enum ComposicaoProduto {
    
    LIQUIDO("Líquido"),
    SOLIDO("Sólido"),;
    
    
    
    private String composicao;

    private ComposicaoProduto(String composicao) {
        this.composicao = composicao;
    }

    public String getComposicao() {
        return composicao;
    }
    
    
   
    
}
