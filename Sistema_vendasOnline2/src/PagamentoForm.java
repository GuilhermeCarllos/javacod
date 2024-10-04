import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

public class PagamentoForm extends JFrame {
    private JTextField txtIdPedido, txtMetodoPagamento, txtValorPago;
    private JButton btnSalvar;

    public PagamentoForm() {
        setTitle("Cadastro de Pagamento");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblIdPedido = new JLabel("ID Pedido:");
        lblIdPedido.setBounds(10, 10, 80, 25);
        add(lblIdPedido);

        txtIdPedido = new JTextField();
        txtIdPedido.setBounds(100, 10, 160, 25);
        add(txtIdPedido);

        JLabel lblMetodoPagamento = new JLabel("Método Pagamento:");
        lblMetodoPagamento.setBounds(10, 40, 140, 25);
        add(lblMetodoPagamento);

        txtMetodoPagamento = new JTextField();
        txtMetodoPagamento.setBounds(150, 40, 110, 25);
        add(txtMetodoPagamento);

        JLabel lblValorPago = new JLabel("Valor Pago:");
        lblValorPago.setBounds(10, 70, 80, 25);
        add(lblValorPago);

        txtValorPago = new JTextField();
        txtValorPago.setBounds(100, 70, 160, 25);
        add(txtValorPago);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 110, 80, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idPedido = Integer.parseInt(txtIdPedido.getText());
                    BigDecimal valorPago = new BigDecimal(txtValorPago.getText());
                    Pedido pedido = new PedidoDAO().listarPedidos().stream()
                            .filter(p -> p.getId() == idPedido)
                            .findFirst()
                            .orElse(null);

                    if (pedido != null) {
                        Pagamento pagamento = new Pagamento(0, pedido, txtMetodoPagamento.getText(), "Pendente", valorPago);
                        new PagamentoDAO().adicionarPagamento(pagamento);
                        JOptionPane.showMessageDialog(null, "Pagamento salvo com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
                    }

                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar pagamento: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        PagamentoForm form = new PagamentoForm();
        form.setVisible(true);
    }
}
