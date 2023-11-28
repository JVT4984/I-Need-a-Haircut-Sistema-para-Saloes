package com.tcc.needahaircut;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

        AgendaEntity agendaID = agendaPedidoDAO.getAgendabyData(data, hora);

        String nomeServico = new String(String.valueOf(servicoDTO.getServico_id()));

        ServicoEntity servicoID = servicoDAO.getServicobyNome(nomeServico);

        AgendaPedidoEntity entity = converter.convertToEntity(dto);
        entity.setServico_id(servicoID);
        entity.setAgenda_id(agendaID);

        AgendaPedidoEntity savedEntity = agendaPedidoDAO.postAgendameto(entity);

        return converter.converterToDTO(savedEntity);
    }

    @GetMapping("agenda")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AgendaDTO> getAgenda(@RequestBody AgendaDTO data, AgendaDTO horario) throws SQLException {
        AgendaEntity entity = new AgendaPedidoDAO().getAgendabyData(data.getData(), horario.getHorario());

        //if (entity == null) {
        //    return ResponseEntity.notFound().build();
        //}

        return ResponseEntity.ok().body(new AgendaConverter().convertToDTO(entity));
    }

    @GetMapping("servico")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ServicoDTO> getServico(@RequestBody ServicoDTO servico_nome) throws SQLException {
        ServicoEntity entity = new AgendaPedidoDAO().getServicobyNome(servico_nome.servico_nome());

        //if (entity == null) {
        //    return ResponseEntity.notFound().build();
        //}

        return ResponseEntity.ok().body(new ServicoConverter().convertNomebyDTO(entity));
    }
}

