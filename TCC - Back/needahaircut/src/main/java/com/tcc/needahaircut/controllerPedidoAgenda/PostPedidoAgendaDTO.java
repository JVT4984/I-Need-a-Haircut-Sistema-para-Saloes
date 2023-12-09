package com.tcc.needahaircut.controllerPedidoAgenda;

import java.time.LocalDate;
import java.time.LocalTime;

public class PostPedidoAgendaDTO {

    public LocalDate data;
    public LocalTime horario;
    public String servico_nome;


    public PostPedidoAgendaDTO(LocalDate data, LocalTime horario, String servico_nome) {
        this.data = data;
        this.horario = horario;
        this.servico_nome = servico_nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getServico_nome() {
        return servico_nome;
    }

    public void setServico_nome(String servico_nome) {
        this.servico_nome = servico_nome;
    }
}
