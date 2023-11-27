package com.tcc.needahaircut;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AgendaPedidoDAO {

    public static AgendaPedidoEntity postAgendameto(AgendaPedidoEntity entity) throws SQLException {
        final String sql = "insert into agdpedidodoservico (cliente_cliente_id, servico_servico_id, agenda_agenda_id) values (?, ?, ?)";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, entity.cliente_id.cliente_id);
            preparedStatement.setInt(2, entity.servico_id.servico_id);
            preparedStatement.setInt(3, entity.agenda_id.agenda_id);
            preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                rs.next();
                entity.agendamento_id = rs.getInt(1);
                return entity;
            }
        }
    }
}
