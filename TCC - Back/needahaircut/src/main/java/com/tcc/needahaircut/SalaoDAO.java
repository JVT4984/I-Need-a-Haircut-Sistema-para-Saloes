package com.tcc.needahaircut;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalaoDAO {

    public static List<SalaoDTO> getSaloes() throws SQLException {
        String sql = "select * from salao;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<SalaoDTO> saloes = new ArrayList<>();
                while (rs.next()) {
                    SalaoDTO salao = new SalaoDTO();
                    salao.salao_id = rs.getInt(1);
                    salao.salao_nome = rs.getString(2);
                    salao.salao_cnpj = rs.getString(3);
                    salao.salao_telefone = rs.getString(4);
                    salao.salao_email = rs.getString(5);
                    salao.salao_senha = rs.getString(6);
                    salao.salao_endereco = rs.getInt(7);
                    saloes.add(salao);
                }
                return saloes;
            }
        }
    }

    public static SalaoDTO postSalao(SalaoDTO salaoNovo) throws SQLException {
        String sql = "insert into salao (salao_nome, salao_cnpj, salao_telefone, salao_email, salao_senha, endereco_endereco_id) values (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, salaoNovo.salao_nome);
            preparedStatement.setString(2, salaoNovo.salao_cnpj);
            preparedStatement.setString(3, salaoNovo.salao_telefone);
            preparedStatement.setString(4, salaoNovo.salao_email);
            preparedStatement.setString(5, salaoNovo.salao_senha);
            preparedStatement.setInt(6, salaoNovo.salao_endereco);
            preparedStatement.execute();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                rs.next();
                salaoNovo.salao_id = rs.getInt(1);
            }
        }
        return salaoNovo;
    }

    public static SalaoDTO getSalaoByID(int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement("select * from salao where salao_id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                SalaoDTO salao = new SalaoDTO();
                while (rs.next()) {
                    salao.salao_id = rs.getInt(1);
                    salao.salao_nome = rs.getString(2);
                    salao.salao_cnpj = rs.getString(3);
                    salao.salao_telefone = rs.getString(4);
                    salao.salao_email = rs.getString(5);
                    salao.salao_senha = rs.getString(6);
                    salao.salao_endereco = rs.getInt(7);
                }
                return salao;
            }
        }
    }

    public static SalaoDTO deleteSalao(int id) throws SQLException {
        SalaoDTO salao = getSalaoByID(id);
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement( "delete from salao where salao_id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }
        return salao;
    }
}
