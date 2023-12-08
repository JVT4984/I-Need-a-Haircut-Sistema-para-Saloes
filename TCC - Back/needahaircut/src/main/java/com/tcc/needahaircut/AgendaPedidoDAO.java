package com.tcc.needahaircut;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AgendaPedidoDAO {

    public AgendaPedidoEntity postAgendameto(AgendaPedidoEntity entity) throws SQLException {
        final String sql = "insert into agdpedidodoservico (cliente_cliente_id, servico_servico_id, agenda_agenda_id) values (?, ?, ?)";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1, entity.cliente_id.cliente_id);
            preparedStatement.setInt(2, entity.servico_id.servico_id);
            preparedStatement.setInt(3, entity.agenda_id.agenda_id);
            preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                rs.next();
                entity.agendamento_id = rs.getInt(1);
                return entity;
            }
        }
    }

    public int getAgendabyData(LocalDate dataAgenda, LocalTime hrInicio) throws SQLException {
        final String sql = "select agenda_id from agenda where agenda_data = ? and hrInicio = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setDate(1, Date.valueOf(dataAgenda));
            preparedStatement.setTime(2, Time.valueOf(hrInicio));

            try (final ResultSet resultadoAgenda = preparedStatement.executeQuery()) {
                if (!resultadoAgenda.next()) {
                    return -1;
                }

                return resultadoAgenda.getInt("agenda_id");
            }
        }
    }

    public int getServicoID(String servico) throws SQLException {
        final String sql = "select servico_id from servico where servico_nome = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, servico);

            try (final ResultSet resultServico = preparedStatement.executeQuery()) {
                if (!resultServico.next()) {
                    return -1;
                }

                return resultServico.getInt("servico_id");
            }
        }
    }

    public ServicoEntity getServicobyNome(String nomeServico) throws SQLException {
        final String sql = "select servico_id from servico where servico_nome = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, nomeServico);

            try (final ResultSet resultadoServico = preparedStatement.executeQuery()) {
                if (!resultadoServico.next()) {
                    return null;
                }

                int servico_id = resultadoServico.getInt("servico_id");

                return new ServicoEntity(servico_id);
            }
        }
    }




    public AgendaPedidoEntity updateAgendamento(AgendaPedidoEntity entity, int id) throws SQLException {
        final String sql = "UPDATE agdpedidodoservico SET cliente_cliente_id = ?, servico_servico_id = ?, agenda_agenda_id = ? WHERE agendamento_id = ?";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, entity.cliente_id.getCliente_id());
            preparedStatement.setInt(2, entity.servico_id.getServico_id());
            preparedStatement.setInt(3, entity.agenda_id.getAgenda_id());
            preparedStatement.setInt(4, id);
            int pedidoAlterado = preparedStatement.executeUpdate();

            if (pedidoAlterado == 0) {
                return null;
            }
            entity.agendamento_id = id;
            return entity;
        }
    }

    public AgendaPedidoEntity deleteAgendamento(int id) throws SQLException {
        final AgendaPedidoEntity agendamentoDeletado = getAgendaID(id);

        final String sql = "delete from agdpedidodoservico WHERE agendamento_id = ?";
        try (final PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            int linhaAlterada = preparedStatement.executeUpdate();

            if (linhaAlterada == 0) {
                return null;
            }

            return agendamentoDeletado;
        }
    }

    public AgendaPedidoEntity getAgendaID(int idFilter) throws SQLException {
        final String sql = "select * from agdpedidodoservico where agendamento_id = ?";
        try (final  PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, idFilter);

            try (final ResultSet resultadoAgenda = preparedStatement.executeQuery()) {
                if (!resultadoAgenda.next()) {
                    return null;
                }

                int id = resultadoAgenda.getInt("agendamento_id");
                int clienteId = resultadoAgenda.getInt("cliente_cliente_id");
                ClienteEntity clienteEntity = new ClienteEntity();
                clienteEntity.setCliente_id(clienteId);
                int servicoId = resultadoAgenda.getInt("servico_servico_id");
                ServicoEntity servicoEntity = new ServicoEntity();
                servicoEntity.setServico_id(servicoId);
                int agendaId = resultadoAgenda.getInt("agenda_agenda_id");
                AgendaEntity agendaEntity = new AgendaEntity();
                agendaEntity.setAgenda_id(agendaId);

                AgendaPedidoEntity agendaPedidoEntity = new AgendaPedidoEntity();
                agendaPedidoEntity.setAgendamento_id(id);
                agendaPedidoEntity.setCliente_id(clienteEntity);
                agendaPedidoEntity.setServico_id(servicoEntity);
                agendaPedidoEntity.setAgenda_id(agendaEntity);

                return agendaPedidoEntity;
            }
        }
    }

    public AgendaPedidoEntity excluirPedidobyCliente(int cliente_id) throws SQLException {
        String sql = "delete from agdpedidodoservico where cliente_cliente_id = ?";
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, cliente_id);
            preparedStatement.executeUpdate();
        }
        return null;
    }

    public List<AgendaPedidoEntity> getAgendaCliente(int idCliente) throws SQLException {
        List<AgendaPedidoEntity> agendamento = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(
                "SELECT agdpedidodoservico.agendamento_id, cliente.cliente_id, cliente.cliente_nome, servico.servico_nome, servico.servico_valor, agenda.agenda_data, agenda.hrInicio " +
                        "FROM agdpedidodoservico " +
                        "INNER JOIN cliente ON agdpedidodoservico.cliente_cliente_id = cliente.cliente_id " +
                        "INNER JOIN servico ON agdpedidodoservico.servico_servico_id = servico.servico_id " +
                        "INNER JOIN agenda ON agdpedidodoservico.agenda_agenda_id = agenda.agenda_id " +
                        "Where cliente_cliente_id = ?")) {
            preparedStatement.setInt(1, idCliente);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    AgendaPedidoEntity pedido = new AgendaPedidoEntity();
                    ClienteEntity cliente = new ClienteEntity();
                    ServicoEntity servico = new ServicoEntity();
                    AgendaEntity agenda = new AgendaEntity();
                    pedido.agendamento_id = rs.getInt(1);
                    cliente.cliente_id = rs.getInt(2);
                    cliente.cliente_nome = rs.getString(3);
                    servico.servico_nome = rs.getString(4);
                    servico.servico_valor = rs.getDouble(5);
                    agenda.data = rs.getDate(6).toLocalDate();
                    agenda.hrInicio = rs.getTime(7).toLocalTime();
                    pedido.setCliente_id(cliente);
                    pedido.setServico_id(servico);
                    pedido.setAgenda_id(agenda);
                    agendamento.add(pedido);
                }
                return agendamento;
            }
        }
    }

    public List<AgendaPedidoEntity> getAgendaSalao() throws SQLException {
        List<AgendaPedidoEntity> agendamento = new ArrayList<>();
        try (PreparedStatement preparedStatement = ConnectionSingleton.getConnection().prepareStatement(
                "SELECT agdpedidodoservico.agendamento_id, cliente.cliente_id, cliente.cliente_nome, servico.servico_nome, servico.servico_valor, agenda.agenda_data, agenda.hrInicio " +
                        "FROM agdpedidodoservico " +
                        "INNER JOIN cliente ON agdpedidodoservico.cliente_cliente_id = cliente.cliente_id " +
                        "INNER JOIN servico ON agdpedidodoservico.servico_servico_id = servico.servico_id " +
                        "INNER JOIN agenda ON agdpedidodoservico.agenda_agenda_id = agenda.agenda_id ")) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    AgendaPedidoEntity pedido = new AgendaPedidoEntity();
                    ClienteEntity cliente = new ClienteEntity();
                    ServicoEntity servico = new ServicoEntity();
                    AgendaEntity agenda = new AgendaEntity();
                    pedido.agendamento_id = rs.getInt(1);
                    cliente.cliente_id = rs.getInt(2);
                    cliente.cliente_nome = rs.getString(3);
                    servico.servico_nome = rs.getString(4);
                    servico.servico_valor = rs.getDouble(5);
                    agenda.data = rs.getDate(6).toLocalDate();
                    agenda.hrInicio = rs.getTime(7).toLocalTime();
                    pedido.setCliente_id(cliente);
                    pedido.setServico_id(servico);
                    pedido.setAgenda_id(agenda);
                    agendamento.add(pedido);
                }
                return agendamento;
            }
        }
    }
}
