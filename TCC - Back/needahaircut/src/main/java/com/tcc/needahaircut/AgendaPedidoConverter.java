package com.tcc.needahaircut;

import org.springframework.stereotype.Component;

@Component
public class AgendaPedidoConverter {

    public AgendaPedidoEntity convertToEntity(AgendaPedidoDTO agendaPedidoDTO) {
        AgendaPedidoEntity agendaPedidoEntity = new AgendaPedidoEntity();

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCliente_id(agendaPedidoDTO.getCliente_id());
        agendaPedidoEntity.setCliente_id(clienteEntity);

        ServicoEntity servicoEntity = new ServicoEntity();
        servicoEntity.setServico_id(agendaPedidoDTO.getServico_id());
        agendaPedidoEntity.setServico_id(servicoEntity);

        AgendaEntity agendaEntity = new AgendaEntity();
        agendaEntity.setAgenda_id(agendaPedidoDTO.getAgenda_id());
        agendaPedidoEntity.setAgenda_id(agendaEntity);

        return agendaPedidoEntity;
    }

    public AgendaPedidoEntity convertToEntityPost(int clienteID, int agendaID, int servicoID) {
        AgendaPedidoEntity agendaPedidoEntity = new AgendaPedidoEntity();

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setCliente_id(clienteID);
        agendaPedidoEntity.setCliente_id(clienteEntity);

        ServicoEntity servicoEntity = new ServicoEntity();
        servicoEntity.setServico_id(servicoID);
        agendaPedidoEntity.setServico_id(servicoEntity);

        AgendaEntity agendaEntity = new AgendaEntity();
        agendaEntity.setAgenda_id(agendaID);
        agendaPedidoEntity.setAgenda_id(agendaEntity);

        return agendaPedidoEntity;
    }

    public AgendaPedidoDTO converterToDTO(AgendaPedidoEntity agendaPedidoEntity) {
        AgendaPedidoDTO agendaPedidoDTO = new AgendaPedidoDTO();
        agendaPedidoDTO.setAgendamento_id(agendaPedidoEntity.getAgendamento_id());
        agendaPedidoDTO.setCliente_id(agendaPedidoEntity.getCliente_id().cliente_id);
        agendaPedidoDTO.setAgenda_id(agendaPedidoEntity.getAgenda_id().agenda_id);
        agendaPedidoDTO.setServico_id(agendaPedidoEntity.getServico_id().servico_id);

        return agendaPedidoDTO;
    }

    public AgendaPedidoDTO convertToDTOpost(int clienteID, int agendaID, int servicoID) {
        AgendaPedidoDTO agendaPedidoDTO = new AgendaPedidoDTO();
        agendaPedidoDTO.setCliente_id(clienteID);
        agendaPedidoDTO.setAgenda_id(agendaID);
        agendaPedidoDTO.setServico_id(servicoID);

        return agendaPedidoDTO;
    }
    public AgendaPedidoEntity coverterToEntityAgenda(AgendaDTO agendaDTO) {
        AgendaPedidoEntity agendaPedidoEntity = new AgendaPedidoEntity();
        agendaPedidoEntity.setAgendamento_id(agendaDTO.getAgenda_id());

        return agendaPedidoEntity;
    }


}
