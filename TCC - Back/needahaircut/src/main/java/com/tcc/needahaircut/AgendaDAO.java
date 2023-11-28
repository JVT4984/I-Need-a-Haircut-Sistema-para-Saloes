package com.tcc.needahaircut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    public static List<AgendaEntity> getAgenda() throws SQLException {
        String sql = "select agenda_data, hrInicio from agenda;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<AgendaEntity> agendaEntities = new ArrayList<>();
                while (rs.next()) {
                    AgendaEntity agendaEntity = new AgendaEntity();
                    agendaEntity.data = rs.getDate(1);
                    agendaEntity.hrInicio = rs.getTime(2);
                    agendaEntities.add(agendaEntity);
                }
                return agendaEntities;
            }
        }
    }

}
