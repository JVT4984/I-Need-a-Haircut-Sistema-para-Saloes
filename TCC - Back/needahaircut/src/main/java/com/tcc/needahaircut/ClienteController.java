package com.tcc.needahaircut;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ClienteController {

    @PostMapping("/cliente/")
    public ClienteDTO postCliente(@RequestBody ClienteDTO clienteDTO) throws SQLException {
        new ClienteDAO().postCliente(clienteDTO);
        return clienteDTO;
    }

    @GetMapping("/cliente/")
    public List<ClienteDTO> getClientes() throws SQLException {
        return ClienteDAO.getCliente();
    }
}
