import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

public class PedidoForm extends JFrame {
    private JTextField txtIdCliente, txtValorTotal;
    private JButton btnSalvar;

    public PedidoForm() {
        setTitle("Cadastro de Pedido");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblIdCliente = new JLabel("ID Cliente:");
        lblIdCliente.setBounds(10, 10, 80, 25);
        add(lblIdCliente);

        txtIdCliente = new JTextField();
        txtIdCliente.setBounds(100, 10, 160, 25);
        add(txtIdCliente);

        JLabel lblData = new JLabel("Data:");
        lblData.setBounds(10, 40, 80, 25);
        add(lblData);

        JLabel lblValorTotal = new JLabel("Valor Total:");
        lblValorTotal.setBounds(10, 70, 80, 25);
        add(lblValorTotal);

        txtValorTotal = new JTextField();
        txtValorTotal.setBounds(100, 70, 160, 25);
        add(txtValorTotal);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 110, 80, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new ClienteDAO().buscarPorId(Integer.parseInt(txtIdCliente.getText()));
                    if (cliente != null) {
                        // Criando o pedido com BigDecimal
                        BigDecimal valorTotal = new BigDecimal(txtValorTotal.getText());
                        Pedido pedido = new Pedido(0, cliente, new Date(), valorTotal, "Pendente"); // Adicionando status
                        new PedidoDAO().adicionarPedido(pedido);
                        JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar pedido: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor total deve ser um número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        PedidoForm form = new PedidoForm();
        form.setVisible(true);
    }
}
