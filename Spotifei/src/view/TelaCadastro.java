/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */


import controller.UsuarioController;
import javax.swing.*;

public class TelaCadastro extends JFrame {
    public TelaCadastro() {
        setTitle("Cadastro de Usuário");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 80, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 20, 160, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(20, 60, 80, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 60, 160, 25);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 100, 80, 25);
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 100, 160, 25);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 140, 120, 25);

        JButton btnVoltar = new JButton("Voltar ao Login");
        btnVoltar.setBounds(100, 180, 120, 25);

        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String senha = new String(txtSenha.getPassword());
            if (UsuarioController.cadastrar(nome, email, senha)) {
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                dispose();
                new TelaLogin().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário.");
            }
        });

        btnVoltar.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });

        add(lblNome); add(txtNome);
        add(lblEmail); add(txtEmail);
        add(lblSenha); add(txtSenha);
        add(btnCadastrar); add(btnVoltar);
    }
}