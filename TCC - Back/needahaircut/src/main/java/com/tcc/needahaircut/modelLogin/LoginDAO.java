package com.tcc.needahaircut.modelLogin;

import com.tcc.needahaircut.ConnectionSingleton;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Integer NivelAcesso(String token) throws SQLException {
        String sql = "select cliente_cliente_id from login WHERE token = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, token);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1);
                } else {
                    return -1;
                }
            }
        }
    }

    public int tokenExisteCliente(String token) throws SQLException {
        String sql = "select cliente_cliente_id from login where token = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, token);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1);
                } else {
                    return -1;
                }
            }
        }
    }

    public int tokenExisteSalao(String token) throws SQLException {
        String sql = "select salao_salao_id from login where token = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, token);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt(1);
                } else {
                    return -1;
                }
            }
        }
    }

    public LoginEntity excluirLogin(int cliente_id) throws SQLException {
        String sql = "delete from login where cliente_cliente_id = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, cliente_id);
            preparedStatement.executeUpdate();
        }
        return null;
    }
}

