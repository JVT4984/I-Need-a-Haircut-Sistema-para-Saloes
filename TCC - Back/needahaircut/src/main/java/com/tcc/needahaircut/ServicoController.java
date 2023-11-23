package com.tcc.needahaircut;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/servico/")

public class ServicoController {

    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<ServicoEntity> getServico() throws SQLException {
        return ServicoDAO.getServicos();
    }
}
