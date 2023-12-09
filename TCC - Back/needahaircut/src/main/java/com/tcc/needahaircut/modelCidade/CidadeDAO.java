package com.tcc.needahaircut.modelCidade;

import com.tcc.needahaircut.ConnectionSingleton;
import com.tcc.needahaircut.modelEstado.EstadoDAO;
import com.tcc.needahaircut.modelEstado.EstadoEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDAO {

    public static CidadeEntity getCidadeById(int id) throws SQLException {
        String sql = "select * from cidade where cidade_id = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    CidadeEntity cidade = new CidadeEntity();
                    cidade.cidade_id = rs.getInt(1);
                    cidade.cidade_nome = rs.getString(2);

                    int estado_id = rs.getInt(3);

                    EstadoEntity estado = EstadoDAO.getEstadoById(estado_id);

                    cidade.estado_id = estado;
                    return cidade;
                }else {
                    System.out.println("Não te endereço");
                    return null;
                }
            }
        }
    }
}
