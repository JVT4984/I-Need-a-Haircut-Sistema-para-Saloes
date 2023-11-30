package com.tcc.needahaircut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

@RestController
@RequestMapping("/agendaPedido/")
public class AgendaPedidoController {

    @Autowired
    public AgendaPedidoDAO agendaPedidoDao;
    @Autowired
    public AgendaPedidoConverter agendaPedidoConverter;

    @PostMapping()
    @CrossOrigin(origins = "*")
    public ResponseEntity<AgendaPedidoDTO> postPedido(@RequestBody AgendaPedidoDTO dto) throws SQLException {
        AgendaPedidoConverter converter = agendaPedidoConverter;
        AgendaPedidoDTO agendaPedidoDTO = converter.converterToDTO(agendaPedidoDao.postAgendameto(converter.convertToEntity(dto)));
        return ResponseEntity.ok(agendaPedidoDTO);
    }

    @GetMapping("agenda")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Integer> getAgenda(@RequestBody AgendaDTO agendaDto) throws SQLException {
        int idAgendaPedido = agendaPedidoDao.getAgendabyData(agendaDto.getData(), agendaDto.getHorario());

        if (idAgendaPedido < 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(idAgendaPedido);
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

    @PutMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AgendaPedidoDTO> putPedido(@RequestBody AgendaPedidoDTO dto, @PathVariable int id) throws SQLException {
        AgendaPedidoConverter converter = agendaPedidoConverter;
        AgendaPedidoDTO agendaPedidoDTO = converter.converterToDTO(agendaPedidoDao.updateAgendamento(converter.convertToEntity(dto), id));
        return ResponseEntity.ok(agendaPedidoDTO);
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AgendaPedidoDTO> deletPedido(@PathVariable int id) throws SQLException {
        AgendaPedidoEntity agendaPedidoEntity = agendaPedidoDao.getAgendaID(id);

        if (agendaPedidoEntity == null) {
            return ResponseEntity.notFound().build();
        }

        agendaPedidoDao.deleteAgendamento(id);
        AgendaPedidoDTO agendaPedidoDTO = agendaPedidoConverter.converterToDTO(agendaPedidoEntity);

        return ResponseEntity.ok().body(agendaPedidoDTO);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AgendaPedidoDTO> getAgendaByID(@PathVariable int id) throws SQLException {
        AgendaPedidoEntity agendaPedidoEntity = agendaPedidoDao.getAgendaID(id);

        if (agendaPedidoEntity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(agendaPedidoConverter.converterToDTO(agendaPedidoEntity));
    }
}

