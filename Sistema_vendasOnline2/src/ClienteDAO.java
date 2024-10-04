import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    // Construtor que estabelece a conexão com o banco de dados
    public ClienteDAO() throws SQLException {
        this.connection = ConexaoMySQL.getConexao();
    }

    // Método para adicionar um novo cliente ao banco de dados
    public void adicionarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nome, cpf, endereco) VALUES (?, ?, ?)"; // Adicionando endereco
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco()); // Adicionando o endereço
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("endereco") // Adicionando o endereço
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Novo método para listar todos os clientes
    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes"; // Supondo que a tabela se chama clientes

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco")); // Acesso ao endereço
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Método para buscar um cliente por ID
    public Cliente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("endereco") // Adicionando o endereço
                    );
                }
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }

    // Método opcional: buscar cliente por nome
    public List<Cliente> buscarPorNome(String nome) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente WHERE nome LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%"); // Usa LIKE para buscar pelo nome
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("endereco") // Adicionando o endereço
                    );
                    clientes.add(cliente);
                }
            }
        }
        return clientes;
    }

    // Método opcional: buscar cliente por CPF
    public Cliente buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("endereco") // Adicionando o endereço
                    );
                }
            }
        }
        return null; // Retorna null se o cliente não for encontrado
    }
}
