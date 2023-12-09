package com.tcc.needahaircut.modelEstado;

import com.tcc.needahaircut.ConnectionSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO {

    public static EstadoEntity getEstadoById(int id) throws SQLException {
        String sql = "select * from estado where estado_id = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    EstadoEntity estado = new EstadoEntity();
                    estado.estado_id = rs.getInt(1);
                    estado.estado_nome = rs.getString(2);
                    estado.estado_codigo = rs.getString(3);
                    return estado;
                }else {
                    System.out.println("Não te estado");
                    return null;
                }
            }
        }
    }
}
