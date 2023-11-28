package com.tcc.needahaircut;

public class AgendaPedidoConverter {

    public AgendaPedidoEntity convertToEntity(AgendaPedidoDTO agendaPedidoDTO) {
        AgendaPedidoEntity agendaPedidoEntity = new AgendaPedidoEntity();
        agendaPedidoEntity.setAgendamento_id(agendaPedidoDTO.getAgendamneto_id());

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCliente_id(agendaPedidoDTO.getCliente_id());

        ServicoEntity servicoEntity = new ServicoEntity();
        servicoEntity.setServico_id(agendaPedidoDTO.getServico_id());

        AgendaEntity agendaEntity = new AgendaEntity();
        agendaEntity.setAgenda_id(agendaPedidoDTO.getAgenda_id());

        return agendaPedidoEntity;
    }

    public AgendaPedidoDTO converterToDTO(AgendaPedidoEntity agendaPedidoEntity) {
        AgendaPedidoDTO agendaPedidoDTO = new AgendaPedidoDTO();
        agendaPedidoDTO.setAgendamneto_id(agendaPedidoEntity.getAgendamento_id());
        agendaPedidoDTO.setCliente_id(agendaPedidoEntity.getCliente_id().cliente_id);
        agendaPedidoDTO.setAgenda_id(agendaPedidoEntity.getAgenda_id().agenda_id);
        agendaPedidoDTO.setServico_id(agendaPedidoEntity.getServico_id().servico_id);

        return agendaPedidoDTO;
    }
}
