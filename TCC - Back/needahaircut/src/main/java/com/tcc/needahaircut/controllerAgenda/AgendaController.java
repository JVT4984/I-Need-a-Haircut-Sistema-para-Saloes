package com.tcc.needahaircut.controllerAgenda;

import com.tcc.needahaircut.modalAgenda.AgendaDAO;
import com.tcc.needahaircut.modalAgenda.AgendaEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/agenda/")
public class AgendaController {

    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<AgendaDTO> getAgenda() throws SQLException {
        final AgendaConverter converter = new AgendaConverter();

        List<AgendaEntity> entities = new AgendaDAO().getAgenda();
        return converter.convertToDTOList(entities);
    }
}
