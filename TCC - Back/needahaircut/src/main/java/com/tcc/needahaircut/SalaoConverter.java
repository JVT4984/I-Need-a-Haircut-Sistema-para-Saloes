package com.tcc.needahaircut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

public class SalaoConverter {

    @Autowired
    public EnderecoConverter enderecoConverter;

    public List<SalaoDTO> toDTO(List<SalaoEntity> entities) {
        return entities.stream().map(entity -> new SalaoDTO(entity.salao_id, entity.salao_nome, entity.salao_cnpj, entity.salao_telefone, entity.salao_email, entity.salao_senha, entity.endereco_endereco_id)).collect(Collectors.toList());
    }

    public SalaoDTO toDTO(SalaoEntity entity) {
        return new SalaoDTO(entity.salao_id, entity.salao_nome, entity.salao_cnpj, entity.salao_telefone, entity.salao_email, entity.salao_senha, entity.endereco_endereco_id);
    }

    public SalaoEntity toEntity(SalaoDTO dto) {

        int id = dto.endereco_endereco_id;

        EnderecoConverter enderecoConverter1 = enderecoConverter;
        EnderecoDTO enderecoDTO = enderecoConverter1.toEntityEndereco(enderecoConverter.toEntityEndereco(id));
        // TODO converter




        return new SalaoEntity(dto.salao_id, dto.salao_nome, dto.salao_cnpj, dto.salao_telefone, dto.salao_email, dto.salao_senha, id);
    }
}
