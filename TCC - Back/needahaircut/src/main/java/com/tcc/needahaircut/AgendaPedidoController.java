package com.tcc.needahaircut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/agendaPedido/")
public class AgendaPedidoController {

    @Autowired
    public AgendaPedidoDAO agendaPedidoDao;
    @Autowired
    public AgendaPedidoConverter agendaPedidoConverter;

    @Autowired
    public LoginDAO loginDAO;

    @PostMapping()
    @CrossOrigin(origins = "*")
    public ResponseEntity<AgendaPedidoDTO> postPedido(@RequestBody PostPedidoAgendaDTO postPedidoAgendaDTO,
                                                      @RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {
        AgendaPedidoConverter converter = agendaPedidoConverter;
        int agendaID = agendaPedidoDao.getAgendabyData(postPedidoAgendaDTO.getData(), postPedidoAgendaDTO.getHorario());

        if (agendaID < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        int servicoID = agendaPedidoDao.getServicoID(postPedidoAgendaDTO.getServico_nome());

        if (servicoID < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        int clienteID = loginDAO.tokenExisteCliente(header);

        if (clienteID < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        System.out.println("Servico" + servicoID);
        System.out.println("Cliente" + clienteID);
        System.out.println("Agenda" + agendaID);
        AgendaPedidoDTO agendaPedidoDTO = converter.converterToDTO(agendaPedidoDao.postAgendameto(converter.convertToEntityPost(clienteID, agendaID, servicoID)));
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

    @GetMapping("servicoTeste")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Integer> getServico(@RequestBody ServicoDTO servicoDTO) throws SQLException {
        int idServicoPedido = agendaPedidoDao.getServicoID(servicoDTO.getServico_nome());

        if (idServicoPedido < 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(idServicoPedido);
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

    @GetMapping("servicoAgenda")
    @CrossOrigin(origins = "*")
    public List<ServicoEntity> getServicoID_Nome() throws SQLException {
        return ServicoDAO.getServicosAgenda();
    }

    @GetMapping("clienteAgenda")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<GetAgendamentoClienteDTO>> getAgendamentoCliente(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {

        int clienteID = loginDAO.tokenExisteCliente(header);
        if (clienteID < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


    }

}

