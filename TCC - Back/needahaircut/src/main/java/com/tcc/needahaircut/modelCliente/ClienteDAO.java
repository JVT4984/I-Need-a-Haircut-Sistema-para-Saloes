package com.tcc.needahaircut.modelCliente;

import com.tcc.needahaircut.ConnectionSingleton;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class ClienteDAO {

    public static List<ClienteEntity> getCliente() throws SQLException {
        String sql = "select * from cliente;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<ClienteEntity> clientes = new ArrayList<>();
                while (rs.next()) {
                    ClienteEntity cliente = new ClienteEntity();
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

    public static ClienteEntity postCliente(ClienteEntity entity) {
        final String sql = "insert into cliente (cliente_nome, cliente_sobrenome, cliente_cpf, cliente_telefone, cliente_email, cliente_senha) values (?, ?, ?, ?, ?, ?);";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, entity.cliente_nome);
            preparedStatement.setString(2, entity.cliente_sobrenome);
            preparedStatement.setString(3, entity.cliente_cpf);
            preparedStatement.setString(4, entity.cliente_telefone);
            preparedStatement.setString(5, entity.cliente_email);
            preparedStatement.setString(6, entity.cliente_senha);
            preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                rs.next();
                entity.cliente_id = rs.getInt(1);
                return entity;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteEntity delete(int id) throws SQLException {
        final ClienteEntity clienteASerApagado = getClienteID(id);

        final String sql = "DELETE FROM cliente WHERE cliente_id = ?";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int linhaAlterada = preparedStatement.executeUpdate();

            if (linhaAlterada == 0) {
                return null;
            }

            return clienteASerApagado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteEntity getClienteID(int idFilter) throws SQLException {
        final String sql = "select * from cliente where cliente_id = ?";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, idFilter);

            try (final ResultSet resultadoCliente = preparedStatement.executeQuery()) {
                if (!resultadoCliente.next()) {
                    return null;
                }

                int id = resultadoCliente.getInt("cliente_id");
                String nome = resultadoCliente.getString("cliente_nome");
                String sobrenome = resultadoCliente.getString("cliente_sobrenome");
                String cpf = resultadoCliente.getString("cliente_cpf");
                String telefone = resultadoCliente.getString("cliente_telefone");
                String email = resultadoCliente.getString("cliente_email");
                String senha = resultadoCliente.getString("cliente_senha");

                return new ClienteEntity(id, nome, sobrenome, cpf, telefone, email, senha);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ClienteEntity updateCliente(ClienteEntity entity, int id) {
        final String sql = "UPDATE cliente SET cliente_nome = ?, cliente_sobrenome = ? , cliente_cpf = ? , cliente_telefone = ? , cliente_email = ? , cliente_senha = ?  WHERE cliente_id = ?";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, entity.cliente_nome);
            preparedStatement.setString(2, entity.cliente_sobrenome);
            preparedStatement.setString(3, entity.cliente_cpf);
            preparedStatement.setString(4, entity.cliente_telefone);
            preparedStatement.setString(5, entity.cliente_email);
            preparedStatement.setString(6, entity.cliente_senha);
            preparedStatement.setInt(7, id);
            int linhasAlteradas = preparedStatement.executeUpdate();

            if (linhasAlteradas == 0) {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        entity.cliente_id = id;
        return entity;
    }

    public ClienteEntity getByCliente(String email, String senha) throws SQLException {
        String sql = "select * from cliente where cliente_email = ? AND cliente_senha = ? ";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            try (final ResultSet resultadoCliente = preparedStatement.executeQuery()) {
                if (!resultadoCliente.next()) {
                    return null;
                }

                ClienteEntity cliente1 = new ClienteEntity();
                cliente1.cliente_id = resultadoCliente.getInt(1);
                cliente1.cliente_email = resultadoCliente.getString(2);
                cliente1.cliente_senha = resultadoCliente.getString(3);

                return cliente1;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
