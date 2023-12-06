package com.tcc.needahaircut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SalaoController {

    @Autowired
    public LoginDAO loginDAO;

    @GetMapping("/salao/")
    public List<SalaoEntity> getSalao() throws SQLException {
        return SalaoDAO.getSaloes();
    }

    @PutMapping("/salao/put")
    @CrossOrigin(origins = "*")
    public ResponseEntity<SalaoDTO> putCliente(@RequestBody SalaoDTO dto, @RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {

        int salaoID = loginDAO.tokenExisteSalao(header);
            if (salaoID < 0) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        final SalaoConverter converter = new SalaoConverter();

        SalaoEntity entity = new SalaoDAO().updateSalao(converter.toEntity(dto), salaoID);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(converter.toDTO(entity));
    }

    @GetMapping("/salao/id")
    @CrossOrigin(origins = "*")
    public ResponseEntity<GetSalaoDTO> getSalaoByID(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {

        int salaoID = loginDAO.tokenExisteSalao(header);
            if (salaoID < 0) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        final GetSalaoConverter converter = new GetSalaoConverter();

        SalaoEntity entity = new SalaoDAO().getSalaoByID(salaoID);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(converter.convertToDto(entity));
    }

    @GetMapping("/salaoTeste/")
    @CrossOrigin(origins = "*")
    public List<GetSalaoDTO> getSalaoTeste() throws SQLException {
        final GetSalaoConverter converter = new GetSalaoConverter();

        List<SalaoEntity> entities = new SalaoDAO().getSalaoByTeste();
        return converter.convertToDtoTeste(entities);
    }
}
