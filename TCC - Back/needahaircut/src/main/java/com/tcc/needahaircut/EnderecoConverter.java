package com.tcc.needahaircut;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoConverter {

    public List<EnderecoDTO> toDTOendereco(List<EnderecoEntity> entities) {
        return entities.stream().map(entity -> new EnderecoDTO(entity.endereco_id, entity.endereco_bairro, entity.endereco_rua, entity.endereco_numero, entity.endereco_complemento, entity.cidade_cidade_id)).collect(Collectors.toList());
    }
}
