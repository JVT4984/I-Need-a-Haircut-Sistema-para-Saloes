package com.tcc.needahaircut.modelSalao;

import com.tcc.needahaircut.*;
import com.tcc.needahaircut.modelCidade.CidadeEntity;
import com.tcc.needahaircut.modelEndereco.EnderecoEntity;
import com.tcc.needahaircut.modelEstado.EstadoEntity;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class SalaoDAO {

    public static List<SalaoEntity> getSaloes() throws SQLException {
        String sql = "select * from salao;";
        try (Statement statement = ConnectionSingleton.getConnection().createStatement()) {
            try (ResultSet rs = statement.executeQuery(sql)) {
                List<SalaoEntity> saloes = new ArrayList<>();
                while (rs.next()) {
                    SalaoEntity salao = new SalaoEntity();
                    salao.salao_id = rs.getInt(1);
                    salao.salao_nome = rs.getString(2);
                    salao.salao_cnpj = rs.getString(3);
                    salao.salao_telefone = rs.getString(4);
                    salao.salao_email = rs.getString(5);
                    salao.salao_senha = rs.getString(6);
                    saloes.add(salao);
                }
                return saloes;
            }
        }
    }

    //public static SalaoEntity postSalao(SalaoEntity salaoNovo) throws SQLException {
    //    String sql = "insert into salao (salao_nome, salao_cnpj, salao_telefone, salao_email, salao_senha, endereco_endereco_id) values (?, ?, ?, ?, ?, ?);";
    //    try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
    //        preparedStatement.setString(1, salaoNovo.salao_nome);
    //        preparedStatement.setString(2, salaoNovo.salao_cnpj);
    //        preparedStatement.setString(3, salaoNovo.salao_telefone);
    //        preparedStatement.setString(4, salaoNovo.salao_email);
    //        preparedStatement.setString(5, salaoNovo.salao_senha);
    //        preparedStatement.setInt(6, salaoNovo.endereco_endereco_id.endereco_id);
    //        preparedStatement.execute();
    //        try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
    //            rs.next();
    //            salaoNovo.salao_id = rs.getInt(1);
    //        }
    //    }
    //    return salaoNovo;
    //}

    public SalaoEntity updateSalao(SalaoEntity entity, int id) {
        final String sql = "UPDATE salao SET salao_nome = ?, salao_cnpj = ? , salao_telefone = ? , salao_email = ? , salao_senha = ?  WHERE salao_id = ?";
        try (final  PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, entity.salao_nome);
            preparedStatement.setString(2, entity.salao_cnpj);
            preparedStatement.setString(3, entity.salao_telefone);
            preparedStatement.setString(4, entity.salao_email);
            preparedStatement.setString(5, entity.salao_senha);

            preparedStatement.setInt(6, id);
            int linhasAlteradas = preparedStatement.executeUpdate();

            if (linhasAlteradas == 0) {
                return null;
            }
            entity.salao_id = id;
            return entity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SalaoEntity getSalaoByID(int id) throws SQLException {
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(
                "SELECT salao_nome, salao_cnpj, salao_telefone, salao_email, salao_senha, estado_nome, cidade_nome, endereco_bairro, endereco_rua, endereco_numero " +
                        "FROM salao " +
                        "JOIN endereco ON salao.endereco_endereco_id = endereco.endereco_id " +
                        "JOIN cidade ON endereco.cidade_cidade_id = cidade.cidade_id " +
                        "JOIN estado ON cidade.estado_estado_id = estado.estado_id " +
                        "WHERE salao_id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                SalaoEntity salao = new SalaoEntity();
                EnderecoEntity endereco = new EnderecoEntity();
                CidadeEntity cidade = new CidadeEntity();
                EstadoEntity estado = new EstadoEntity();
                while (rs.next()) {
                    salao.salao_nome = rs.getString(1);
                    salao.salao_cnpj = rs.getString(2);
                    salao.salao_telefone = rs.getString(3);
                    salao.salao_email = rs.getString(4);
                    salao.salao_senha = rs.getString(5);
                    estado.estado_nome = rs.getString(6);
                    cidade.cidade_nome = rs.getString(7);
                    endereco.endereco_bairro = rs.getString(8);
                    endereco.endereco_rua = rs.getString(9);
                    endereco.endereco_numero = rs.getString(10);
                    salao.setEndereco_endereco_id(endereco);
                    endereco.setCidadeEntity(cidade);
                    cidade.setEstado_id(estado);
                    estado.setEstado_codigo(estado.getEstado_nome());
                }
                return salao;
            }
        }
    }

    public SalaoEntity getBySalao(String email, String senha) throws SQLException {
        String sql = "select * from salao where salao_email = ? AND salao_senha = ? ";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            try (final ResultSet resultadoSalao = preparedStatement.executeQuery()) {
                if (!resultadoSalao.next()) {
                    return null;
                }

                SalaoEntity salao = new SalaoEntity();
                salao.salao_id = resultadoSalao.getInt(1);
                salao.salao_email = resultadoSalao.getString(2);
                salao.salao_senha = resultadoSalao.getString(3);

                return salao;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<SalaoEntity> getSalaoByTeste() throws SQLException {
        List<SalaoEntity> saloes = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(
                "SELECT salao_nome, salao_cnpj, salao_telefone, salao_email, estado_nome, cidade_nome, endereco_bairro, endereco_rua, endereco_numero " +
                        "FROM salao " +
                        "JOIN endereco ON salao.endereco_endereco_id = endereco.endereco_id " +
                        "JOIN cidade ON endereco.cidade_cidade_id = cidade.cidade_id " +
                        "JOIN estado ON cidade.estado_estado_id = estado.estado_id ")) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    SalaoEntity salao = new SalaoEntity();
                    EnderecoEntity endereco = new EnderecoEntity();
                    CidadeEntity cidade = new CidadeEntity();
                    EstadoEntity estado = new EstadoEntity();
                    salao.salao_nome = rs.getString(1);
                    salao.salao_cnpj = rs.getString(2);
                    salao.salao_telefone = rs.getString(3);
                    salao.salao_email = rs.getString(4);
                    estado.estado_nome = rs.getString(5);
                    cidade.cidade_nome = rs.getString(6);
                    endereco.endereco_bairro = rs.getString(7);
                    endereco.endereco_rua = rs.getString(8);
                    endereco.endereco_numero = rs.getString(9);
                    salao.setEndereco_endereco_id(endereco);
                    endereco.setCidadeEntity(cidade);
                    cidade.setEstado_id(estado);
                    estado.setEstado_codigo(estado.getEstado_nome());
                    saloes.add(salao);
                }
            }
        }
        return saloes;
    }


    //public static SalaoDTO deleteSalao(int id) throws SQLException {
     //   SalaoDTO salao = getSalaoByID(id);
    //    try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement( "delete from salao where salao_id = ?")) {
    //        preparedStatement.setInt(1, id);
  //          preparedStatement.execute();
   //     }
  //      return salao;
 //   }
}
