/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controleDeEstoque.model;

import br.com.controleDeEstoque.enuns.EstadoCivil;
import br.com.controleDeEstoque.enuns.Sexo;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Onismar
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Funcionario extends Pessoa implements Serializable{

    private String inscricao;
    private String login;
    private String senha;
    private boolean autorizarDesconto;
    private Double maxDesconto;

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAutorizarDesconto() {
        return autorizarDesconto;
    }

    public void setAutorizarDesconto(boolean autorizarDesconto) {
        this.autorizarDesconto = autorizarDesconto;
    }
   

   

    public Double getMaxDesconto() {
        return maxDesconto;
    }

    public void setMaxDesconto(Double maxDesconto) {
        this.maxDesconto = maxDesconto;
    }
    
    

   

   
}
