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

    @GetMapping("/cliente/{id}")
    public ClienteDTO getClienteByID(@PathVariable("id") int id) throws SQLException {
        return ClienteDAO.getClienteByID(id);
    }

    @DeleteMapping("/cliente/{id}")
    public ClienteDTO deletarCliente(@PathVariable("id") int id) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        ClienteDTO cliente = ClienteDAO.getClienteByID(id);
        clienteDAO.deleteCliente(id);
        return cliente;
    }

    @PutMapping("/cliente/{id}")
    public ClienteDTO updateCliente(@PathVariable("id") int id, @RequestBody ClienteDTO clienteNovo) throws SQLException {
        return new ClienteDAO().updateCliente(id, clienteNovo);
    }
}
