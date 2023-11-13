package com.tcc.needahaircut;

import java.util.List;
import java.util.stream.Collectors;

public class SalaoConverter {

    public List<SalaoDTO> toDTO(List<SalaoEntity> entities) {
        return entities.stream().map(entity -> new SalaoDTO(entity.salao_id, entity.salao_nome, entity.salao_cnpj, entity.salao_telefone, entity.salao_email, entity.salao_senha, entity.endereco_id)).collect(Collectors.toList());
    }

    public SalaoDTO toDTO(SalaoEntity entity) {return new SalaoDTO(entity.salao_id, entity.salao_nome, entity.salao_cnpj, entity.salao_telefone, entity.salao_email, entity.salao_senha, entity.endereco_id);}

    public SalaoEntity toEntity(SalaoDTO dto) {return new SalaoEntity(dto.salao_id, dto.salao_nome, dto.salao_cnpj, dto.salao_telefone, dto.salao_email, dto.salao_senha, dto.enderecoEntity);}
}
