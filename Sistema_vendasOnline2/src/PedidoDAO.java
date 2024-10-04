import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class PedidoDAO {
    private Connection connection;

    public PedidoDAO() throws SQLException {
        this.connection = ConexaoMySQL.getConexao();
    }

    public void adicionarPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO Pedido (id_cliente, data, total, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setDate(2, new java.sql.Date(pedido.getData().getTime()));
            stmt.setBigDecimal(3, pedido.getTotal());
            stmt.setString(4, pedido.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Pedido> listarPedidos() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new ClienteDAO().buscarPorId(rs.getInt("id_cliente"));
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        cliente,
                        rs.getDate("data"),
                        rs.getBigDecimal("total"),
                        rs.getString("status")
                );
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }
}
