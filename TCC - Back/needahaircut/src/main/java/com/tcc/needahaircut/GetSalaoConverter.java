package com.tcc.needahaircut;

public class GetSalaoConverter {

    public SalaoEntity convertToEntity(GetSalaoDTO getSalaoDTO) {
        SalaoEntity salaoEntity = new SalaoEntity();
        salaoEntity.setSalao_id(getSalaoDTO.getSalao_id());
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
        getSalaoDTO.setSalao_id(salaoEntity.getSalao_id());
        getSalaoDTO.setSalao_nome(salaoEntity.getSalao_nome());
        getSalaoDTO.setSalao_cnpj(salaoEntity.getSalao_cnpj());
        getSalaoDTO.setSalao_telefone(salaoEntity.getSalao_telefone());
        getSalaoDTO.setSalao_email(salaoEntity.getSalao_email());

        EnderecoEntity enderecoEntity = new EnderecoEntity();
        getSalaoDTO.setBairro(enderecoEntity.getEndereco_bairro());
        getSalaoDTO.setRua(enderecoEntity.getEndereco_rua());
        getSalaoDTO.setNumero(enderecoEntity.getEndereco_numero());

        CidadeEntity cidadeEntity = new CidadeEntity();
        getSalaoDTO.setCidade(cidadeEntity.getCidade_nome());

        EstadoEntity estadoEntity = new EstadoEntity();
        getSalaoDTO.setEstado(estadoEntity.getEstado_nome());

        return getSalaoDTO;
    }

}
