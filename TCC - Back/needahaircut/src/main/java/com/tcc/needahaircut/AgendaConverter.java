package com.tcc.needahaircut;

import java.util.ArrayList;
import java.util.List;

public class AgendaConverter {

    List<AgendaDTO> convertToDTO(List<AgendaEntity> entities) {
        List<AgendaDTO> dtos = new ArrayList<>();
        for (AgendaEntity entity : entities) {
            AgendaDTO dto = new AgendaDTO();
            dto.setAgenda_id(entity.getAgenda_id());
            dto.setData(entity.getData());
            dto.setHorario(entity.getHrInicio());
            dtos.add(dto);
        }
        return dtos;
    }
}
