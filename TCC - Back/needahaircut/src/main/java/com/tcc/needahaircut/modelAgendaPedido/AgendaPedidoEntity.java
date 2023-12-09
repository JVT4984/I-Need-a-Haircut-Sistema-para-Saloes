package com.tcc.needahaircut.modelAgendaPedido;

import com.tcc.needahaircut.modelAvaliacao.AvaliacaoEntity;
import com.tcc.needahaircut.modelServico.ServicoEntity;
import com.tcc.needahaircut.modalAgenda.AgendaEntity;
import com.tcc.needahaircut.modelCliente.ClienteEntity;

public class AgendaPedidoEntity {

    public int agendamento_id;

    public ClienteEntity cliente_id;
    public ServicoEntity servico_id;
    public AvaliacaoEntity avaliacao_id;
    public AgendaEntity agenda_id;

    public AgendaPedidoEntity() {

    }


    public int getAgendamento_id() {
        return agendamento_id;
    }

    public void setAgendamento_id(int agendamento_id) {
        this.agendamento_id = agendamento_id;
    }

    public ClienteEntity getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(ClienteEntity cliente_id) {
        this.cliente_id = cliente_id;
    }

    public ServicoEntity getServico_id() {
        return servico_id;
    }

    public void setServico_id(ServicoEntity servico_id) {
        this.servico_id = servico_id;
    }

    public AvaliacaoEntity getAvaliacao_id() {
        return avaliacao_id;
    }

    public void setAvaliacao_id(AvaliacaoEntity avaliacao_id) {
        this.avaliacao_id = avaliacao_id;
    }

    public AgendaEntity getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(AgendaEntity agenda_id) {
        this.agenda_id = agenda_id;
    }

    public AgendaPedidoEntity(int agendamento_id, ClienteEntity cliente_id, ServicoEntity servico_id, AvaliacaoEntity avaliacao_id, AgendaEntity agenda_id) {
        this.agendamento_id = agendamento_id;
        this.cliente_id = cliente_id;
        this.servico_id = servico_id;
        this.avaliacao_id = avaliacao_id;
        this.agenda_id = agenda_id;
    }
}
