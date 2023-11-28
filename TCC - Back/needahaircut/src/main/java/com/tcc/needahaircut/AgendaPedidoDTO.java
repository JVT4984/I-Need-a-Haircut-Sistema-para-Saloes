package com.tcc.needahaircut;

public class AgendaPedidoDTO {

    public int agendamneto_id;

    public int cliente_id;
    public int servico_id;
    public int avaliacao_id;
    public int agenda_id;

    public AgendaPedidoDTO() {

    }


    public int getAgendamneto_id() {
        return agendamneto_id;
    }

    public void setAgendamneto_id(int agendamneto_id) {
        this.agendamneto_id = agendamneto_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getServico_id() {
        return servico_id;
    }

    public void setServico_id(int servico_id) {
        this.servico_id = servico_id;
    }

    public int getAvaliacao_id() {
        return avaliacao_id;
    }

    public void setAvaliacao_id(int avaliacao_id) {
        this.avaliacao_id = avaliacao_id;
    }

    public int getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(int agenda_id) {
        this.agenda_id = agenda_id;
    }

    public AgendaPedidoDTO(int agendamneto_id, int cliente_id, int servico_id, int avaliacao_id, int agenda_id) {
        this.agendamneto_id = agendamneto_id;
        this.cliente_id = cliente_id;
        this.servico_id = servico_id;
        this.avaliacao_id = avaliacao_id;
        this.agenda_id = agenda_id;
    }
}
