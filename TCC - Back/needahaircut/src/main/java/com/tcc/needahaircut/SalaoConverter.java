package com.tcc.needahaircut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

public class SalaoConverter {

    public List<SalaoDTO> toDTO(List<SalaoEntity> entities) {
        return entities.stream().map(entity -> {

            int endereco_id = entity.getEndereco_endereco_id().endereco_id;

            return new SalaoDTO(entity.salao_id, entity.salao_nome, entity.salao_cnpj, entity.salao_telefone, entity.salao_email, entity.salao_senha, endereco_id);
        }).collect(Collectors.toList());
    }

    public SalaoDTO toDTO(SalaoEntity entity) {

        int endereco_id = entity.getEndereco_endereco_id().endereco_id;

        return new SalaoDTO(entity.salao_id, entity.salao_nome, entity.salao_cnpj, entity.salao_telefone, entity.salao_email, entity.salao_senha, endereco_id);
    }

    public SalaoEntity toEntity(SalaoDTO dto) {


        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setEndereco_id(dto.getEndereco_endereco_id());


        return new SalaoEntity(dto.salao_id, dto.salao_nome, dto.salao_cnpj, dto.salao_telefone, dto.salao_email, dto.salao_senha, enderecoEntity);
    }
}
