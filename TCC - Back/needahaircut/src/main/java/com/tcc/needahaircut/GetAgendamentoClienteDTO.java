package com.tcc.needahaircut;

import java.time.LocalDate;
import java.time.LocalTime;

public class GetAgendamentoClienteDTO {

    public int agendamento_id;
    public int agendaCliente_id;
    public String cliente_nome;
    public String servico_nome;
    public String servico_valor;
    public LocalDate agenda_data;
    public LocalTime agenda_hora;


    public GetAgendamentoClienteDTO(){

    }


    public GetAgendamentoClienteDTO(int agendamento_id, int agendaCliente_id, String cliente_nome, String servico_nome, String servico_valor, LocalDate agenda_data, LocalTime agenda_hora) {
        this.agendamento_id = agendamento_id;
        this.agendaCliente_id = agendaCliente_id;
        this.cliente_nome = cliente_nome;
        this.servico_nome = servico_nome;
        this.servico_valor = servico_valor;
        this.agenda_data = agenda_data;
        this.agenda_hora = agenda_hora;
    }

    public int getAgendamento_id() {
        return agendamento_id;
    }

    public void setAgendamento_id(int agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public int getAgendaCliente_id() {
        return agendaCliente_id;
    }

    public void setAgendaCliente_id(int agendaCliente_id) {
        this.agendaCliente_id = agendaCliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getServico_nome() {
        return servico_nome;
    }

    public void setServico_nome(String servico_nome) {
        this.servico_nome = servico_nome;
    }

    public String getServico_valor() {
        return servico_valor;
    }

    public void setServico_valor(String servico_valor) {
        this.servico_valor = servico_valor;
    }

    public LocalDate getAgenda_data() {
        return agenda_data;
    }

    public void setAgenda_data(LocalDate agenda_data) {
        this.agenda_data = agenda_data;
    }

    public LocalTime getAgenda_hora() {
        return agenda_hora;
    }

    public void setAgenda_hora(LocalTime agenda_hora) {
        this.agenda_hora = agenda_hora;
    }
}
