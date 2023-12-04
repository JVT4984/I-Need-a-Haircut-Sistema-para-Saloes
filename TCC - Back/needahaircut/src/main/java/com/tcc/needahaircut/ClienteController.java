package com.tcc.needahaircut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cliente/")
public class ClienteController {

    @Autowired
    public LoginDAO loginDAO;

    @PostMapping()
    @CrossOrigin(origins = "*")
    public ClienteDTO postPessoa(@RequestBody ClienteDTO dto) {
        final ClienteConverter converter = new ClienteConverter();
        return converter.toDTO(new ClienteDAO().postCliente(converter.toEntity(dto)));
    }

    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<ClienteEntity> getClientes() throws SQLException {
        return ClienteDAO.getCliente();
    }

    @GetMapping("get")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClienteDTO> getCliente(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {

        int clienteID = loginDAO.tokenExisteCliente(header);
            if (clienteID < 0) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        ClienteEntity entity = new ClienteDAO().getClienteID(clienteID);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok().body(new  ClienteConverter().toDTO(entity));
    }

    @DeleteMapping("excluir")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClienteDTO> deletePessoa(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {

        int clienteID = loginDAO.tokenExisteCliente(header);
        if (clienteID < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        AgendaPedidoEntity agendaDelete = new AgendaPedidoDAO().excluirPedidobyCliente(clienteID);
        LoginEntity loginDelete = new LoginDAO().excluirLogin(clienteID);
        ClienteEntity entity = new ClienteDAO().delete(clienteID);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new ClienteConverter().toDTO(entity));
    }

    @PutMapping("edit")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClienteDTO> putCliente(@RequestBody ClienteDTO dto,
                                                 @RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {
        int clienteID = loginDAO.tokenExisteCliente(header);
        if (clienteID < 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final ClienteConverter converter = new ClienteConverter();
        ClienteEntity entity = new ClienteDAO().updateCliente(converter.toEntity(dto), clienteID);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(converter.toDTO(entity));
    }
}
