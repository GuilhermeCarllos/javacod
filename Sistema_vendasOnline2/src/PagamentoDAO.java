import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    private Connection connection;

    public PagamentoDAO() throws SQLException {
        this.connection = ConexaoMySQL.getConexao();
    }

    public void adicionarPagamento(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO Pagamento (id_pedido, metodo_pagamento, status, valor_pago) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pagamento.getPedido().getId());
            stmt.setString(2, pagamento.getFormaPagamento());
            stmt.setString(3, pagamento.getStatus());
            stmt.setBigDecimal(4, pagamento.getValorPago());
            stmt.executeUpdate();
        }
    }

    public List<Pagamento> listarPagamentos() throws SQLException {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM Pagamento";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                Pedido pedido = new PedidoDAO().listarPedidos().stream()
                        .filter(p -> p.getId() == idPedido)
                        .findFirst()
                        .orElse(null);

                Pagamento pagamento = new Pagamento(
                        rs.getInt("id"),
                        pedido,
                        rs.getString("metodo_pagamento"),
                        rs.getString("status"),
                        rs.getBigDecimal("valor_pago")
                );
                pagamentos.add(pagamento);
            }
        }
        return pagamentos;
    }
}
