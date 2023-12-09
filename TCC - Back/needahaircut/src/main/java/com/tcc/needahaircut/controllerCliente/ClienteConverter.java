package com.tcc.needahaircut.controllerCliente;

import com.tcc.needahaircut.modelCliente.ClienteEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteConverter {

    public List<ClienteDTO> toDTO(List<ClienteEntity> entities) {
        return entities //
                .stream() //
                .map(entity -> new ClienteDTO(entity.cliente_id, entity.cliente_nome, entity.cliente_sobrenome, entity.cliente_cpf, entity.cliente_telefone, entity.cliente_email, entity.cliente_senha)) //
                .collect(Collectors.toList());
    }

    public ClienteDTO toDTO(ClienteEntity entity) {return new ClienteDTO(entity.cliente_id, entity.cliente_nome, entity.cliente_sobrenome, entity.cliente_cpf, entity.cliente_telefone, entity.cliente_email, entity.cliente_senha);}

    public ClienteEntity toEntity(ClienteDTO dto) {return new ClienteEntity(dto.cliente_id, dto.cliente_nome, dto.cliente_sobrenome, dto.cliente_cpf, dto.cliente_telefone, dto.cliente_email, dto.cliente_senha);}

}