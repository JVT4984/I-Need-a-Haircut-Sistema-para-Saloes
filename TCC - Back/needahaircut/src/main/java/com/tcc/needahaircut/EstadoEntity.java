package com.tcc.needahaircut;

public class EstadoEntity {
    public int estado_id;
    public String estado_nome;
    public String estado_codigo;

    public EstadoEntity(int estado_id, String estado_nome, String estado_codigo) {
        this.estado_id = estado_id;
        this.estado_nome = estado_nome;
        this.estado_codigo = estado_codigo;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado_nome() {
        return estado_nome;
    }

    public void setEstado_nome(String estado_nome) {
        this.estado_nome = estado_nome;
    }

    public String getEstado_codigo() {
        return estado_codigo;
    }

    public void setEstado_codigo(String estado_codigo) {
        this.estado_codigo = estado_codigo;
    }
}
