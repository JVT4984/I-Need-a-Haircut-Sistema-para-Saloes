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
    public AgendaPedidoDTO postPedido(@RequestBody AgendaPedidoDTO dto) throws SQLException {
        final AgendaPedidoConverter converter = new AgendaPedidoConverter();
        final AgendaDAO agendaDAO = new AgendaDAO();
        final ServicoDAO servicoDAO = new ServicoDAO();
        final AgendaPedidoDAO agendaPedidoDAO = new AgendaPedidoDAO();

        Date data = new Date(dto.getAgenda_id());
        Time hora = new Time(dto.getAgenda_id());

        AgendaEntity agendaID = agendaDAO.getAgendabyNome(data, hora);

        String nomeServico = new String(String.valueOf(dto.getServico_id()));

        ServicoEntity servicoID = servicoDAO.getServicobyNome(nomeServico);

        AgendaPedidoEntity entity = converter.convertToEntity(dto);
        entity.setServico_id(servicoID);
        entity.setAgenda_id(agendaID);

        AgendaPedidoEntity savedEntity = agendaPedidoDAO.postAgendameto(entity);

        return converter.converterToDTO(savedEntity);
    }



}
