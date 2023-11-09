package com.tcc.needahaircut;

public class CidadeDTO {
    public int cidade_id;
    public String cidade_nome;
    public EstadoEntity estadoEntity;

    public CidadeDTO(int cidade_id, String cidade_nome, EstadoEntity estadoEntity) {
        this.cidade_id = cidade_id;
        this.cidade_nome = cidade_nome;
        this.estadoEntity = estadoEntity;
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

    public EstadoEntity getEstadoEntity() {
        return estadoEntity;
    }

    public void setEstadoEntity(EstadoEntity estadoEntity) {
        this.estadoEntity = estadoEntity;
    }

    public CidadeDTO(){

    }
}
