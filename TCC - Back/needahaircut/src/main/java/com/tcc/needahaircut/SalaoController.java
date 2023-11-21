package com.tcc.needahaircut;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class SalaoController {

    @GetMapping("/salao/")
    public List<SalaoEntity> getSalao() throws SQLException {
        return SalaoDAO.getSaloes();
    }

   // @PostMapping("/salao/")
   // public SalaoDTO postSalao(@RequestBody SalaoDTO salaoDTO) throws SQLException {
    //    new SalaoDAO().postSalao(new SalaoEntity());
   //     return salaoDTO;
 //   }

    @PutMapping("/salao/{id}")
    public ResponseEntity<SalaoDTO> putCliente(@RequestBody SalaoDTO dto, @PathVariable int id) {
        final SalaoConverter converter = new SalaoConverter();

        SalaoEntity entity = new SalaoDAO().updateSalao(converter.toEntity(dto), id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(converter.toDTO(entity));
    }

    @GetMapping("/salao/{id}")
    public ResponseEntity<GetSalaoDTO> getSalaoByID(@PathVariable int id) throws SQLException {
        final GetSalaoConverter converter = new GetSalaoConverter();

        SalaoEntity entity = new SalaoDAO().getSalaoByID(id);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(converter.convertToDto(entity));
    }

   // @DeleteMapping("/salao/{id}")
  //  public SalaoDTO deletarSalao(@PathVariable("id") int id) throws SQLException {
   //     SalaoDAO salaoDAO = new SalaoDAO();
   //     SalaoDTO salao = SalaoDAO.getSalaoByID(id);
    //    salaoDAO.deleteSalao(id);
    //    return salao;
  //  }
}
