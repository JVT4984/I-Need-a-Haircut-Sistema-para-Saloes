package com.tcc.needahaircut;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cliente/")
public class ClienteController {

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

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClienteDTO> getCliente(@PathVariable int id) throws SQLException {
        ClienteEntity entity = new ClienteDAO().getClienteID(id);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok().body(new  ClienteConverter().toDTO(entity));
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClienteDTO> deletePessoa(@PathVariable int id) throws SQLException {
        ClienteEntity entity = new ClienteDAO().delete(id);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new ClienteConverter().toDTO(entity));
    }

    @PutMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ClienteDTO> putCliente(@RequestBody ClienteDTO dto, @PathVariable int id) {
        final ClienteConverter converter = new ClienteConverter();
        ClienteEntity entity = new ClienteDAO().updateCliente(converter.toEntity(dto), id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(converter.toDTO(entity));
    }
}
