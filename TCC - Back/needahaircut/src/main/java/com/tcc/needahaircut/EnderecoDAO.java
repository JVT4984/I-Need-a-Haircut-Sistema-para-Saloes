package com.tcc.needahaircut;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {

    public static EnderecoEntity getEnderecoById(int id) throws SQLException {
        String sql = "select * from endereco where endereco_id = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    EnderecoEntity endereco = new EnderecoEntity();
                    endereco.endereco_id = rs.getInt(1);
                    endereco.endereco_bairro = rs.getString(2);
                    endereco.endereco_rua = rs.getString(3);
                    endereco.endereco_numero = rs.getString(4);
                    endereco.endereco_complemento = rs.getString(5);

                    int cidade_id = rs.getInt(6);

                    CidadeEntity cidade = CidadeDAO.getCidadeById(cidade_id);

                    endereco.cidadeEntity = cidade;
                    return endereco;
                }else {
                    System.out.println("Não te endereço");
                    return null;
                }
            }
        }
    }
}
