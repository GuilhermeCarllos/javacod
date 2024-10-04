import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal; // Importa BigDecimal
import java.sql.SQLException;

public class ProdutoForm extends JFrame {
    private JTextField txtDescricao, txtValor;
    private JButton btnSalvar;

    public ProdutoForm() {
        setTitle("Cadastro de Produto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(10, 10, 80, 25);
        add(lblDescricao);

        txtDescricao = new JTextField();
        txtDescricao.setBounds(100, 10, 160, 25);
        add(txtDescricao);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(10, 40, 80, 25);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(100, 40, 160, 25);
        add(txtValor);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 110, 80, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Converte o valor para BigDecimal
                    BigDecimal valor = new BigDecimal(txtValor.getText());
                    Produto produto = new Produto(0, txtDescricao.getText(), valor);
                    new ProdutoDAO().adicionarProduto(produto);
                    JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar produto: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valor deve ser um número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        ProdutoForm form = new ProdutoForm();
        form.setVisible(true);
    }
}
