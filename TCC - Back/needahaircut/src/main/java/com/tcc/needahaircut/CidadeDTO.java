package com.tcc.needahaircut;

public class CidadeDTO {
    public int cidade_id;
    public String cidade_nome;
    public int estado_estado_id;

    public CidadeDTO(int cidade_id, String cidade_nome, int estado_estado_id) {
        this.cidade_id = cidade_id;
        this.cidade_nome = cidade_nome;
        this.estado_estado_id = estado_estado_id;
    }

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getCidade_nome() {
        return cidade_nome;
    }

    public void setCidade_nome(String cidade_nome) {
        this.cidade_nome = cidade_nome;
    }

    public int getEstado_estado_id() {
        return estado_estado_id;
    }

    public void setEstado_estado_id(int estado_estado_id) {
        this.estado_estado_id = estado_estado_id;
    }

    public CidadeDTO(){

    }
}
