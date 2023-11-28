package com.tcc.needahaircut;

import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

@RestController
@RequestMapping("/agendaPedido/")
public class AgendaPedidoController {

    @PostMapping()
    @CrossOrigin(origins = "*")
    public AgendaPedidoDTO postPedido(@RequestBody AgendaDTO agendaDTO, ServicoDTO servicoDTO, AgendaPedidoDTO dto) throws SQLException {
        final AgendaPedidoConverter converter = new AgendaPedidoConverter();
        final AgendaDAO agendaDAO = new AgendaDAO();
        final ServicoDAO servicoDAO = new ServicoDAO();
        final AgendaPedidoDAO agendaPedidoDAO = new AgendaPedidoDAO();

        Date data = new Date(agendaDTO.getAgenda_id());
        Time hora = new Time(agendaDTO.getAgenda_id());

        AgendaEntity agendaID = agendaDAO.getAgendabyNome(data, hora);

        String nomeServico = new String(String.valueOf(servicoDTO.getServico_id()));

        ServicoEntity servicoID = servicoDAO.getServicobyNome(nomeServico);

        AgendaPedidoEntity entity = converter.convertToEntity(dto);
        entity.setServico_id(servicoID);
        entity.setAgenda_id(agendaID);

        AgendaPedidoEntity savedEntity = agendaPedidoDAO.postAgendameto(entity);

        return converter.converterToDTO(savedEntity);
    }



}
