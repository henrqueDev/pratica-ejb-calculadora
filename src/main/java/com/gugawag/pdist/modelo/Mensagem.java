package com.gugawag.pdist.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity(name = "tb_mensagem")
public class Mensagem implements Serializable {

    @Id
    private long id;
    private String conteudo;

    public Mensagem(){

    }

    public Mensagem(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public long getId() {
        return id;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
