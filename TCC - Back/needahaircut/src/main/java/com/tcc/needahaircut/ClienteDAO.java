package com.tcc.needahaircut;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static List<ClienteDTO> getCliente() throws SQLException {
        String sql = "select * from cliente;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<ClienteDTO> clientes = new ArrayList<>();
                while (rs.next()) {
                    ClienteDTO cliente = new ClienteDTO();
                    cliente.cliente_id = rs.getInt(1);
                    cliente.cliente_nome = rs.getString(2);
                    cliente.cliente_sobrenome = rs.getString(3);
                    cliente.cliente_cpf = rs.getString(4);
                    cliente.cliente_telefone = rs.getString(5);
                    cliente.cliente_email = rs.getString(6);
                    cliente.cliente_senha = rs.getString(7);
                    clientes.add(cliente);
                }
                return clientes;
            }
        }
    }

    public static ClienteDTO postCliente(ClienteDTO clienteNovo) throws SQLException {
        String sql = "insert into cliente (cliente_nome, cliente_sobrenome, cliente_cpf, cliente_telefone, cliente_email, cliente_senha) values (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, clienteNovo.cliente_nome);
            preparedStatement.setString(2, clienteNovo.cliente_sobrenome);
            preparedStatement.setString(3, clienteNovo.cliente_cpf);
            preparedStatement.setString(4, clienteNovo.cliente_telefone);
            preparedStatement.setString(5, clienteNovo.cliente_email);
            preparedStatement.setString(6, clienteNovo.cliente_senha);
            preparedStatement.execute();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                rs.next();
                clienteNovo.cliente_id = rs.getInt(1);
            }
        }
        return clienteNovo;
    }

    public static ClienteDTO deleteCliente(int id) throws SQLException {
        ClienteDTO cliente = getClienteByID(id);
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement( "delete from cliente where cliente_id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        return cliente;
    }

    public static ClienteDTO getClienteByID(int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement("select * from cliente where cliente_id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                ClienteDTO cliente = new ClienteDTO();
                while (rs.next()) {
                    cliente.cliente_id = rs.getInt(1);
                    cliente.cliente_nome = rs.getString(2);
                    cliente.cliente_sobrenome = rs.getString(3);
                    cliente.cliente_cpf = rs.getString(4);
                    cliente.cliente_telefone = rs.getString(5);
                    cliente.cliente_email = rs.getString(6);
                    cliente.cliente_senha = rs.getString(7);
                }
                return cliente;
            }
        }
    }

    public static ClienteDTO updateCliente(int id, ClienteDTO clienteAtualizado) throws SQLException {
        String sql = "UPDATE cliente SET cliente_nome = ?, cliente_sobrenome = ? , cliente_cpf = ? , cliente_telefone = ? , cliente_email = ? , cliente_senha = ?  WHERE cliente_id = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, clienteAtualizado.cliente_nome);
            preparedStatement.setString(2, clienteAtualizado.cliente_sobrenome);
            preparedStatement.setString(3, clienteAtualizado.cliente_cpf);
            preparedStatement.setString(4, clienteAtualizado.cliente_telefone);
            preparedStatement.setString(5, clienteAtualizado.cliente_email);
            preparedStatement.setString(6, clienteAtualizado.cliente_senha);
            preparedStatement.setInt(7, id);
            preparedStatement.execute();
        }
        return getClienteByID(id);
    }
}
