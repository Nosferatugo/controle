/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.strategy;

import br.com.controleDeEstoque.model.Contato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Onismar
 */
public class RemoverContatos implements IRemoverContatos{

    @Override
    public List<Contato>  removerListaContaos(List<Contato> lista,String numero) {
        List<Contato> novaLista =  new ArrayList<Contato>();
       if(!numero.equals(" ")){
          
           for(Contato c : lista){
           if(c.getNumero().equals(numero)){
               lista.remove(c);
               novaLista = lista;
           }
       }
    
    }
       return novaLista;
    }
}
