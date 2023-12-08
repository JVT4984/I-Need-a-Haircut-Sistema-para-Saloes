package com.tcc.needahaircut;

import java.util.ArrayList;
import java.util.List;

public class GetAgendaClienteConverter {

    public static List<GetAgendamentoClienteDTO> convertToDTOCliente(List<AgendaPedidoEntity> entities) {
        List<GetAgendamentoClienteDTO> dtos = new ArrayList<>();
        for (AgendaPedidoEntity entity : entities) {
            GetAgendamentoClienteDTO dto = new GetAgendamentoClienteDTO();
            dto.setAgendamento_id(entity.getAgendamento_id());
            dto.setAgendaCliente_id(entity.getCliente_id().cliente_id);
            dto.setCliente_nome(entity.getCliente_id().cliente_nome);
            dto.setServico_nome(entity.getServico_id().servico_nome);
            dto.setServico_valor(entity.getServico_id().servico_valor);
            dto.setAgenda_data(entity.getAgenda_id().data);
            dto.setAgenda_hora(entity.getAgenda_id().hrInicio);
            dtos.add(dto);
        }
        return dtos;
    }
}
