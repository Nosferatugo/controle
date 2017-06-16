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
public enum TipoProduto {
    
    ALIMENTO("Alimento"),
    PRODUTO_DE_LIMPEZA("Produto de limpeza");
    
    private String tipoProduto;

    private TipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }
    
    
    
    
}
