package com.tcc.needahaircut;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class AgendaPedidoDAO {

    public AgendaPedidoEntity postAgendameto(AgendaPedidoEntity entity) throws SQLException {
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

    public int getAgendabyData(LocalDate dataAgenda, LocalTime hrInicio) throws SQLException {
        final String sql = "select agenda_id from agenda where data = ? and hrInicio = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setDate(1, Date.valueOf(dataAgenda));
            preparedStatement.setTime(2, Time.valueOf(hrInicio));

            try (final ResultSet resultadoAgenda = preparedStatement.executeQuery()) {
                if (!resultadoAgenda.next()) {
                    return -1;
                }

                return resultadoAgenda.getInt("agenda_id");
            }
        }
    }

    public static ServicoEntity getServicobyNome(String nomeServico) throws SQLException {
        final String sql = "select servico_id from servico where servico_nome = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, nomeServico);

            try (final ResultSet resultadoServico = preparedStatement.executeQuery()) {
                if (!resultadoServico.next()) {
                    return null;
                }

                int servico_id = resultadoServico.getInt("servico_id");

                return new ServicoEntity(servico_id);
            }
        }
    }
}
