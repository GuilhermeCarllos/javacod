import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Listar extends JFrame {
    private JTextArea textArea;

    public Listar() {
        setTitle("Listar Dados");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnListarClientes = new JButton("Listar Clientes");
        JButton btnListarProdutos = new JButton("Listar Produtos");
        JButton btnListarPedidos = new JButton("Listar Pedidos");
        JButton btnListarPagamentos = new JButton("Listar Pagamentos");

        buttonPanel.add(btnListarClientes);
        buttonPanel.add(btnListarProdutos);
        buttonPanel.add(btnListarPedidos);
        buttonPanel.add(btnListarPagamentos);
        add(buttonPanel, BorderLayout.SOUTH);

        btnListarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarClientes();
            }
        });

        btnListarProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        btnListarPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPedidos();
            }
        });

        btnListarPagamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPagamentos();
            }
        });
    }

    private void listarClientes() {
        try {
            ListarDAO dao = new ListarDAO();
            List<Cliente> clientes = dao.listarClientes();
            textArea.setText("Clientes:\n");
            for (Cliente cliente : clientes) {
                textArea.append("ID: " + cliente.getId() + ", Nome: " + cliente.getNome() +
                        ", CPF: " + cliente.getCpf() + ", Endereço: " + cliente.getEndereco() + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar clientes: " + ex.getMessage());
        }
    }

    private void listarProdutos() {
        try {
            ListarDAO dao = new ListarDAO();
            List<Produto> produtos = dao.listarProdutos();
            textArea.setText("Produtos:\n");
            for (Produto produto : produtos) {
                textArea.append("ID: " + produto.getId() + ", Nome: " + produto.getNome() +
                        ", Descrição: " + produto.getDescricao() + ", Preço: " + produto.getPreco() + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar produtos: " + ex.getMessage());
        }
    }

    private void listarPedidos() {
        try {
            ListarDAO dao = new ListarDAO();
            List<Pedido> pedidos = dao.listarPedidos();
            textArea.setText("Pedidos:\n");
            for (Pedido pedido : pedidos) {
                textArea.append("ID: " + pedido.getId() + ", ID Cliente: " + pedido.getIdCliente() +
                        ", Data: " + pedido.getData() + ", Total: " + pedido.getTotal() + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar pedidos: " + ex.getMessage());
        }
    }

    private void listarPagamentos() {
        try {
            ListarDAO dao = new ListarDAO();
            List<Pagamento> pagamentos = dao.listarPagamentos();
            textArea.setText("Pagamentos:\n");
            for (Pagamento pagamento : pagamentos) {
                textArea.append("ID: " + pagamento.getId() + ", ID Pedido: " + pagamento.getIdPedido() +
                        ", Valor Pago: " + pagamento.getValorPago() + "\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao listar pagamentos: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Listar form = new Listar();
        form.setVisible(true);
    }
}
