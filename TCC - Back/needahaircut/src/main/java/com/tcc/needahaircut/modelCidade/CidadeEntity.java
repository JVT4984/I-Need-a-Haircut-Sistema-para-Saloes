package com.tcc.needahaircut.modelCidade;

import com.tcc.needahaircut.modelEstado.EstadoEntity;

public class CidadeEntity {
    public int cidade_id;
    public String cidade_nome;
    public EstadoEntity estado_id;

    public CidadeEntity(int cidade_id, String cidade_nome, EstadoEntity estado_id) {
        this.cidade_id = cidade_id;
        this.cidade_nome = cidade_nome;
        this.estado_id = estado_id;

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

    public EstadoEntity getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(EstadoEntity estado_id) {
        this.estado_id = estado_id;
    }

    public CidadeEntity(){

    }
}