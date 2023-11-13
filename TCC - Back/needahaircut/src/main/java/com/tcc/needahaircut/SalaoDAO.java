package com.tcc.needahaircut;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

                    int endereco_id = rs.getInt(7);

                    EnderecoEntity endereco = EnderecoDAO.getEnderecoById(endereco_id);

                    salao.endereco_id = endereco;
                    saloes.add(salao);
                }
                return saloes;
            }
        }
    }

    public static SalaoEntity postSalao(SalaoEntity salaoNovo) throws SQLException {
        String sql = "insert into salao (salao_nome, salao_cnpj, salao_telefone, salao_email, salao_senha, endereco_endereco_id) values (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, salaoNovo.salao_nome);
            preparedStatement.setString(2, salaoNovo.salao_cnpj);
            preparedStatement.setString(3, salaoNovo.salao_telefone);
            preparedStatement.setString(4, salaoNovo.salao_email);
            preparedStatement.setString(5, salaoNovo.salao_senha);
            preparedStatement.setInt(6, salaoNovo.endereco_id.getEndereco_id());
            preparedStatement.execute();
            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                rs.next();
                salaoNovo.salao_id = rs.getInt(1);
            }
        }
        return salaoNovo;
    }

    public SalaoEntity updateSalao(SalaoEntity entity, int id) {
        final String sql = "UPDATE salao SET salao_nome = ?, salao_cnpj = ? , salao_telefone = ? , salao_email = ? , salao_senha = ? , endereco_endereco_id = ?  WHERE salao_id = ?";
        try (final  PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, entity.salao_nome);
            preparedStatement.setString(2, entity.salao_cnpj);
            preparedStatement.setString(3, entity.salao_telefone);
            preparedStatement.setString(4, entity.salao_email);
            preparedStatement.setString(5, entity.salao_senha);
            preparedStatement.setInt(6, entity.endereco_id.getEndereco_id());
            preparedStatement.setInt(7, id);
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

    //public static SalaoDTO getSalaoByID(int id) throws SQLException {
      //  try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(
           //     "SELECT salao_nome, salao_cnpj, salao_telefone, salao_email, estado_nome, cidade_nome, endereco_bairro, endereco_rua, endereco_numero, endereco_complemento " +
           //             "FROM salao " +
           //             "JOIN endereco ON salao.endereco_endereco_id = endereco.endereco_id " +
           //             "JOIN cidade ON endereco.cidade_cidade_id = cidade.cidade_id " +
           //             "JOIN estado ON cidade.estado_estado_id = estado.estado_id " +
           //             "WHERE salao_id = ?")) {
          //  preparedStatement.setInt(1, id);
          //  try (ResultSet rs = preparedStatement.executeQuery()) {
            //    SalaoDTO salao = new SalaoDTO();
            //    EnderecoDTO endereco = new EnderecoDTO();
            //    CidadeDTO cidade = new CidadeDTO();
            //    EstadoDTO estado = new EstadoDTO();
            //    while (rs.next()) {
             //       salao.salao_nome = rs.getString(1);
             //       salao.salao_cnpj = rs.getString(2);
             //       salao.salao_telefone = rs.getString(3);
             //       salao.salao_email = rs.getString(4);
             //       estado.estado_nome = rs.getString(5);
             //       cidade.cidade_nome = rs.getString(6);
             //       endereco.endereco_bairro = rs.getString(7);
             //       endereco.endereco_rua = rs.getString(8);
             //       endereco.endereco_numero = rs.getString(9);
             //       endereco.endereco_complemento = rs.getString(10);
             //       cidade.setEstado_estado_id(cidade);
             //       endereco.setCidade_cidade_id(cidade);
             //       salao.setEndereco_endereco_id(endereco);
            //    }
           //     return salao;
         //   }
      //  }
   // }

    //public static SalaoDTO deleteSalao(int id) throws SQLException {
     //   SalaoDTO salao = getSalaoByID(id);
    //    try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement( "delete from salao where salao_id = ?")) {
    //        preparedStatement.setInt(1, id);
  //          preparedStatement.execute();
   //     }
  //      return salao;
 //   }
}
