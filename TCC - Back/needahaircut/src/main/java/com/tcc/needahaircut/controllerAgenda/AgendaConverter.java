package com.tcc.needahaircut.controllerAgenda;

import com.tcc.needahaircut.modalAgenda.AgendaEntity;

import java.util.ArrayList;
import java.util.List;

public class AgendaConverter {

    public List<AgendaDTO> convertToDTOList(List<AgendaEntity> entities) {
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

    public AgendaDTO convertToDTO(AgendaEntity entity) {
        AgendaDTO dto = new AgendaDTO();
        dto.setAgenda_id(entity.getAgenda_id());
        dto.setData(entity.getData());
        dto.setHorario(entity.getHrInicio());
        return dto;
    }

}

