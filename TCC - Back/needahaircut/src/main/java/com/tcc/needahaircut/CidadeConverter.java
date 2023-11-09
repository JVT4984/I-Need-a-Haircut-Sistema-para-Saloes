package com.tcc.needahaircut;

import java.util.List;
import java.util.stream.Collectors;

public class CidadeConverter {

    public List<CidadeDTO> toDTOcidade(List<CidadeEntity> entityes) {
        return entityes.stream().map(entity -> new CidadeDTO(entity.cidade_id, entity.cidade_nome, entity.estado_id)).collect(Collectors.toList());
    }

    public CidadeDTO toDTOcidade(CidadeEntity entity){return new CidadeDTO(entity.cidade_id, entity.cidade_nome, entity.estado_id);}

    public CidadeEntity toEntityCidade(CidadeDTO dto){return new CidadeEntity(dto.cidade_id, dto.cidade_nome, dto.estadoEntity);}
}
