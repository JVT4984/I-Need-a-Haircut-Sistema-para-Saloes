package com.tcc.needahaircut.modalAgenda;

import com.tcc.needahaircut.ConnectionSingleton;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AgendaDAO {

    public static List<AgendaEntity> getAgenda() throws SQLException {
        String sql = "select agenda_data, hrInicio from agenda;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<AgendaEntity> agendaEntities = new ArrayList<>();
                while (rs.next()) {
                    AgendaEntity agendaEntity = new AgendaEntity();
                    agendaEntity.data = rs.getDate(1).toLocalDate();
                    agendaEntity.hrInicio = rs.getTime(2).toLocalTime();
                    agendaEntities.add(agendaEntity);
                }
                return agendaEntities;
            }
        }
    }

}
