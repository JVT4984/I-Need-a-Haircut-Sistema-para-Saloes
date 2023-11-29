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
    public ResponseEntity<AgendaPedidoDTO> postPedido(@RequestBody AgendaDTO agendaDTO, AgendaPedidoDTO dto) throws SQLException {
        int idAgendaPedido = agendaPedidoDao.getAgendabyData(agendaDTO.getData(), agendaDTO.getHorario());

        if (idAgendaPedido < 0) {
            return ResponseEntity.notFound().build();
        }

        AgendaPedidoConverter converter = agendaPedidoConverter;
        int converterAgenda = converter.coverterToEntityAgenda(agendaPedidoDao.postAgendameto(converter.coverterToEntityAgenda(idAgendaPedido)));
        AgendaPedidoDTO agendaPedidoDTO = converter.converterToDTO(agendaPedidoDao.postAgendameto(converter.convertToEntity(dto)));

       // AgendaPedidoEntity entity = converter.convertToEntity(dto);
       // entity.setServico_id(servicoID);
       // entity.setAgenda_id(agendaID);

      // AgendaPedidoEntity savedEntity = agendaPedidoDAO.postAgendameto(entity);

        return converter.converterToDTO(savedEntity);

        return null;
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
}

