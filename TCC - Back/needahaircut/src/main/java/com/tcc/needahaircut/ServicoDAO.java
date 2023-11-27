package com.tcc.needahaircut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public static List<ServicoEntity> getServicos() throws SQLException {
        String sql = "select servico_id, servico_nome, tipo_servico, servico_valor, servico_tempo from servico;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<ServicoEntity> servicos = new ArrayList<>();
                while (rs.next()) {
                    ServicoEntity servico = new ServicoEntity();
                    servico.servico_id = rs.getInt(1);
                    servico.servico_nome = rs.getString(2);
                    servico.servico_tipo = rs.getString(3);
                    servico.servico_valor = rs.getDouble(4);
                    servico.servico_tempo = rs.getTime(5);
                    servicos.add(servico);
                }
                return servicos;
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
