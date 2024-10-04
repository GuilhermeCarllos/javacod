import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListarDAO {
    private Connection connection;

    public ListarDAO() throws SQLException {
        this.connection = ConexaoMySQL.getConexao(); // Certifique-se de que a conexão está correta
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco")
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getBigDecimal("preco")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }

    // Listar todos os pedidos
    public List<Pedido> listarPedidos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"), // ID do cliente
                        rs.getDate("data"),
                        rs.getBigDecimal("total"),
                        rs.getString("status") // Status do pedido
                );
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }

    // Listar todos os pagamentos
    public List<Pagamento> listarPagamentos() throws SQLException {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM pagamento";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getInt("id"),
                        rs.getInt("id_pedido"), // ID do pedido
                        rs.getString("forma_pagamento"),
                        rs.getString("status"),
                        rs.getBigDecimal("valor_pago")
                );
                pagamentos.add(pagamento);
            }
        }
        return pagamentos;
    }
}
