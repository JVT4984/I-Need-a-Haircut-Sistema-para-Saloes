package com.tcc.needahaircut;

import java.sql.*;
import java.text.SimpleDateFormat;

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

    public static AgendaEntity getAgendabyData(Date dataAgenda, Time hrInicio) throws SQLException {
        SimpleDateFormat formatoDestino = new SimpleDateFormat("yyyy-MM-dd");
        String formatoAnoMesDia = formatoDestino.format(dataAgenda);
        final String sql = "select agenda_id from agenda where agenda_data = ? and hrInicio = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, formatoAnoMesDia);
            preparedStatement.setTime(2, hrInicio);

            try (final ResultSet resultadoAgenda = preparedStatement.executeQuery()) {
                if (!resultadoAgenda.next()) {
                    return null;
                }

                int id = resultadoAgenda.getInt("agenda_id");

                return new AgendaEntity(id);
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
