package com.tcc.needahaircut;

public class ServicoConverter {

    public ServicoDTO convertToDto(ServicoEntity servicoEntity) {
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setServico_nome(servicoEntity.getServico_nome());
        servicoDTO.setServico_tipo(servicoEntity.getServico_tipo());
        servicoDTO.setServico_tempo(servicoEntity.getServico_tempo());
        servicoDTO.setServico_valor(servicoEntity.getServico_valor());

        return servicoDTO;
    }
}