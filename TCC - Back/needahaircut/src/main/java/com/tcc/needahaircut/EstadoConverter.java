package com.tcc.needahaircut;

import java.util.List;
import java.util.stream.Collectors;

public class EstadoConverter {

    public List<EstadoDTO> toDTOestado(List<EstadoEntity> entityes) {
        return entityes.stream().map(entity -> new EstadoDTO(entity.estado_id, entity.estado_nome, entity.estado_codigo)).collect(Collectors.toList());
    }

    public EstadoDTO toDTO(EstadoEntity entity){return new EstadoDTO(entity.estado_id, entity.estado_nome, entity.estado_codigo);}

    public EstadoEntity toEntity(EstadoDTO dto){return new EstadoEntity(dto.estado_id, dto.estado_nome, dto.estado_codigo);}
}
