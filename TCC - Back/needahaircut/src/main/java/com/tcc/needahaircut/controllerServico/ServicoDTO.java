package com.tcc.needahaircut.controllerServico;

import java.sql.Time;

public class ServicoDTO {

    public int servico_id;
    public String servico_nome;
    public String servico_tipo;
    public Time servico_tempo;
    public Double servico_valor;

    public ServicoDTO() {

    }

    public int getServico_id() {return servico_id;}

    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }

    public String getServico_nome() {
        return servico_nome;
    }

    public void setServico_nome(String servico_nome) {
        this.servico_nome = servico_nome;
    }

    public String getServico_tipo() {
        return servico_tipo;
    }

    public void setServico_tipo(String servico_tipo) {
        this.servico_tipo = servico_tipo;
    }

    public Time getServico_tempo() {
        return servico_tempo;
    }

    public void setServico_tempo(Time servico_tempo) {
        this.servico_tempo = servico_tempo;
    }

    public Double getServico_valor() {
        return servico_valor;
    }

    public void setServico_valor(Double servico_valor) {
        this.servico_valor = servico_valor;
    }


    public ServicoDTO(String servico_nome, String servico_tipo, Time servico_tempo, Double servico_valor) {
        this.servico_nome = servico_nome;
        this.servico_tipo = servico_tipo;
        this.servico_tempo = servico_tempo;
        this.servico_valor = servico_valor;
    }

    public String servico_nome() {

        return null;
    }
}
