package com.tcc.needahaircut.controllerServico;

import com.tcc.needahaircut.modelServico.ServicoDAO;
import com.tcc.needahaircut.modelServico.ServicoEntity;
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
