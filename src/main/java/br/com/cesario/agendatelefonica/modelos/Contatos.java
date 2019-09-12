/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cesario.agendatelefonica.modelos;

/**
 *
 * @author cesar
 */
public class Contatos {
    private long id;
    private String nome = "Não Informado";
    private String numero_telefone = "Não Informado";

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the numero_telefone
     */
    public String getNumero_telefone() {
        return numero_telefone;
    }

    /**
     * @param numero_telefone the numero_telefone to set
     */
    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

  
    
}
