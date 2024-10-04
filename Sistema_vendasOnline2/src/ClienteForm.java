import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClienteForm extends JFrame {
    private JTextField txtNome, txtCpf, txtEndereco; // Adicionando um campo para o endereço
    private JButton btnSalvar;

    public ClienteForm() {
        setTitle("Cadastro de Cliente");
        setSize(300, 250); // Aumentando o tamanho da janela para acomodar o novo campo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 80, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 10, 160, 25);
        add(txtNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(10, 40, 80, 25);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(100, 40, 160, 25);
        add(txtCpf);

        // Adicionando campo para o endereço
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(10, 70, 80, 25);
        add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(100, 70, 160, 25);
        add(txtEndereco);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 110, 80, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Atualizando a chamada ao construtor para incluir o endereço
                    Cliente cliente = new Cliente(0, txtNome.getText(), txtCpf.getText(), txtEndereco.getText());
                    new ClienteDAO().adicionarCliente(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        ClienteForm form = new ClienteForm();
        form.setVisible(true);
    }
}
