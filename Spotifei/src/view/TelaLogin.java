/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */
import view.TelaBuscarMusica;
import view.MenuPrincipal;
import controller.UsuarioController;
import model.Usuario;
import javax.swing.*;


public class TelaLogin extends JFrame {
    public TelaLogin() {
        setTitle("Login");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 30, 80, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 30, 160, 25);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 70, 80, 25);
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 70, 160, 25);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBounds(100, 110, 100, 25);

        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.setBounds(100, 150, 100, 25);

        btnLogin.addActionListener(e -> {
            String email = txtEmail.getText();
            String senha = new String(txtSenha.getPassword());
            Usuario u = UsuarioController.login(email, senha);
            if (u != null) {
                JOptionPane.showMessageDialog(this, "Bem-vindo, " + u.getNome());
                dispose();
                new MenuPrincipal(u).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Credenciais inválidas.");
            }
        });

        btnCadastro.addActionListener(e -> {
            dispose();
            new TelaCadastro().setVisible(true);
        });

        add(lblEmail); add(txtEmail);
        add(lblSenha); add(txtSenha);
        add(btnLogin); add(btnCadastro);
    }
}
