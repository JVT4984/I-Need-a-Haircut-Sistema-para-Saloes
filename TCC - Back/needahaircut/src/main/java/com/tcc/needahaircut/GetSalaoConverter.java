package com.tcc.needahaircut;

public class GetSalaoConverter {

    public SalaoEntity convertToEntity(GetSalaoDTO getSalaoDTO) {
        SalaoEntity salaoEntity = new SalaoEntity();
        salaoEntity.setSalao_nome(getSalaoDTO.getSalao_nome());
        salaoEntity.setSalao_cnpj(getSalaoDTO.getSalao_cnpj());
        salaoEntity.setSalao_telefone(getSalaoDTO.getSalao_telefone());
        salaoEntity.setSalao_email(getSalaoDTO.getSalao_email());

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        enderecoEntity.setEndereco_bairro(getSalaoDTO.getBairro());
        enderecoEntity.setEndereco_rua(getSalaoDTO.getRua());
        enderecoEntity.setEndereco_numero(getSalaoDTO.getNumero());

        CidadeEntity cidadeEntity = new CidadeEntity();
        cidadeEntity.setCidade_nome(getSalaoDTO.getCidade());

        EstadoEntity estadoEntity = new EstadoEntity();
        estadoEntity.setEstado_nome(getSalaoDTO.getEstado());

        return salaoEntity;
    }




    public GetSalaoDTO convertToDto(SalaoEntity salaoEntity) {
        GetSalaoDTO getSalaoDTO = new GetSalaoDTO();
        getSalaoDTO.setSalao_nome(salaoEntity.getSalao_nome());
        getSalaoDTO.setSalao_cnpj(salaoEntity.getSalao_cnpj());
        getSalaoDTO.setSalao_telefone(salaoEntity.getSalao_telefone());
        getSalaoDTO.setSalao_email(salaoEntity.getSalao_email());
        getSalaoDTO.setBairro(salaoEntity.getEndereco_endereco_id().endereco_bairro);
        getSalaoDTO.setRua(salaoEntity.getEndereco_endereco_id().endereco_rua);
        getSalaoDTO.setNumero(salaoEntity.endereco_endereco_id.endereco_numero);
        getSalaoDTO.setCidade(salaoEntity.endereco_endereco_id.cidadeEntity.cidade_nome);
        getSalaoDTO.setEstado(salaoEntity.endereco_endereco_id.cidadeEntity.estado_id.estado_nome);

        return getSalaoDTO;
    }

}
