import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    public TelaInicial() {
        setTitle("Sistema de Vendas Online");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar painel
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        // Botão para abrir a tela de Cliente
        JButton btnCliente = new JButton("Cadastro de Cliente");
        btnCliente.setBounds(100, 50, 200, 30);
        panel.add(btnCliente);

        // Botão para abrir a tela de Produto
        JButton btnProduto = new JButton("Cadastro de Produto");
        btnProduto.setBounds(100, 90, 200, 30);
        panel.add(btnProduto);

        // Botão para abrir a tela de Pedido
        JButton btnPedido = new JButton("Cadastro de Pedido");
        btnPedido.setBounds(100, 130, 200, 30);
        panel.add(btnPedido);

        // Botão para abrir a tela de Pagamento
        JButton btnPagamento = new JButton("Cadastro de Pagamento");
        btnPagamento.setBounds(100, 170, 200, 30);
        panel.add(btnPagamento);

        // Ação dos botões
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteForm clienteForm = new ClienteForm();
                clienteForm.setVisible(true);
            }
        });

        btnProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProdutoForm produtoForm = new ProdutoForm();
                produtoForm.setVisible(true);
            }
        });

        btnPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PedidoForm pedidoForm = new PedidoForm();
                pedidoForm.setVisible(true);
            }
        });

        btnPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagamentoForm pagamentoForm = new PagamentoForm();
                pagamentoForm.setVisible(true);
            }
        });
    }
}
