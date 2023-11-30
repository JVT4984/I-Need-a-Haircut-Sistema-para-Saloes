package com.tcc.needahaircut;

public class AgendaPedidoDTO {

    public int agendamento_id;

    public int cliente_id;
    public int servico_id;
    public int avaliacao_id;
    public int agenda_id;

    public AgendaPedidoDTO() {

    }


    public int getAgendameto_id() {
        return agendamento_id;
    }

    public void setAgendamento_id(int agendamento_id) {
        this.agendamento_id = agendamento_id;
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

    public AgendaPedidoDTO(int agendamento_id, int cliente_id, int servico_id, int avaliacao_id, int agenda_id) {
        this.agendamento_id = agendamento_id;
        this.cliente_id = cliente_id;
        this.servico_id = servico_id;
        this.avaliacao_id = avaliacao_id;
        this.agenda_id = agenda_id;
    }
}
