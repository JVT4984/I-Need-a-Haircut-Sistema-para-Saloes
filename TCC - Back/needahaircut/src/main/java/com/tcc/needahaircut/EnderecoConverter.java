package com.tcc.needahaircut;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoConverter {

    public List<EnderecoDTO> toDTOendereco(List<EnderecoEntity> entities) {
    return entities.stream().map(entity -> new EnderecoDTO(entity.endereco_id, entity.endereco_bairro, entity.endereco_rua, entity.endereco_numero, entity.endereco_complemento, entity.cidadeEntity)).collect(Collectors.toList());
    }

    public EnderecoDTO toDTOendereco(EnderecoEntity entity) {return new EnderecoDTO(entity.endereco_id, entity.endereco_bairro, entity.endereco_rua, entity.endereco_numero, entity.endereco_complemento, entity.cidadeEntity);}

    public EnderecoEntity toEntityEndereco(EnderecoDTO dto) {return new EnderecoEntity(dto.endereco_id, dto.endereco_bairro, dto.endereco_rua, dto.endereco_numero, dto.endereco_complemento, dto.cidadeEntity);}
}
