package com.tcc.needahaircut.controllerServico;

import com.tcc.needahaircut.modelServico.ServicoEntity;

public class ServicoConverter {

    public ServicoDTO convertToDto(ServicoEntity servicoEntity) {
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setServico_nome(servicoEntity.getServico_nome());
        servicoDTO.setServico_tipo(servicoEntity.getServico_tipo());
        servicoDTO.setServico_tempo(servicoEntity.getServico_tempo());
        servicoDTO.setServico_valor(servicoEntity.getServico_valor());

        return servicoDTO;
    }
    public ServicoDTO convertNomebyDTO(ServicoEntity servicoEntity) {
        ServicoDTO servicoDTO = new ServicoDTO();
        servicoDTO.setServico_nome(servicoEntity.getServico_nome());

        return servicoDTO;
    }
}
