package com.tcc.needahaircut;

import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
@Component
public class LoginDAO {

    public void insertLoginCliente(LoginEntity novoLogin) throws SQLException {
        String sql = "insert into login (cliente_cliente_id, token) values (?, ?)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, novoLogin.cliente_id.cliente_id);
            preparedStatement.setString(2, novoLogin.token);

            preparedStatement.execute();
        }
    }

    public void insertLoginSalao(LoginEntity novoLogin) throws SQLException {
        String sql = "insert into login (salao_salao_id, token) values (?, ?)";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, novoLogin.salao_id.salao_id);
            preparedStatement.setString(2, novoLogin.token);

            preparedStatement.execute();
        }
    }
}
