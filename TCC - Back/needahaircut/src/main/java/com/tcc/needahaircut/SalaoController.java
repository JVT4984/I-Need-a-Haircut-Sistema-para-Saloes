package com.tcc.needahaircut;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SalaoController {

    @GetMapping("/salao/")
    public List<SalaoDTO> getSalao() throws SQLException {
        return SalaoDAO.getSaloes();
    }

    @PostMapping("/salao/")
    public SalaoDTO postSalao(@RequestBody SalaoDTO salaoDTO) throws SQLException {
        new SalaoDAO().postSalao(salaoDTO);
        return salaoDTO;
    }

    @GetMapping("/salao/{id}")
    public SalaoDTO getSalaoByID(@PathVariable("id") int id) throws SQLException {
        return SalaoDAO.getSalaoByID(id);
    }

    @DeleteMapping("/salao/{id}")
    public SalaoDTO deletarSalao(@PathVariable("id") int id) throws SQLException {
        SalaoDAO salaoDAO = new SalaoDAO();
        SalaoDTO salao = SalaoDAO.getSalaoByID(id);
        salaoDAO.deleteSalao(id);
        return salao;
    }
}
