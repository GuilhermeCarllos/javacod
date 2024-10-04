import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Inicia a interface gráfica
        SwingUtilities.invokeLater(() -> {
            // Aqui você pode definir uma tela inicial ou um JFrame que contenha botões para abrir cada form
            JFrame frame = new JFrame("Sistema de Vendas Online");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton clienteButton = new JButton("Cadastro de Cliente");
        clienteButton.setBounds(50, 50, 200, 25);
        clienteButton.addActionListener(e -> new ClienteForm().setVisible(true));
        panel.add(clienteButton);

        JButton produtoButton = new JButton("Cadastro de Produto");
        produtoButton.setBounds(50, 100, 200, 25);
        produtoButton.addActionListener(e -> new ProdutoForm().setVisible(true));
        panel.add(produtoButton);

        JButton pedidoButton = new JButton("Cadastro de Pedido");
        pedidoButton.setBounds(50, 150, 200, 25);
        pedidoButton.addActionListener(e -> new PedidoForm().setVisible(true));
        panel.add(pedidoButton);

        JButton pagamentoButton = new JButton("Cadastro de Pagamento");
        pagamentoButton.setBounds(50, 200, 200, 25);
        pagamentoButton.addActionListener(e -> new PagamentoForm().setVisible(true));
        panel.add(pagamentoButton);

        JButton listarButton = new JButton("Listar Produtos, Clientes e Pedidos");
        listarButton.setBounds(50, 250, 300, 25);
        listarButton.addActionListener(e -> new Listar().setVisible(true));
        panel.add(listarButton);

    }

}
