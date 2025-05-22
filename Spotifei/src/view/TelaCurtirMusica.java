/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */
import DAO.HistoricoDAO;
import DAO.UsuarioDAO;
import model.Usuario;

import javax.swing.*;

public class TelaCurtirMusica extends JFrame {
    private Usuario usuario;
    private UsuarioDAO dao = new UsuarioDAO();
    private JTextField txtId;

    public TelaCurtirMusica(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Curtir / Descurtir Músicas");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblId = new JLabel("ID da música:");
        lblId.setBounds(20, 30, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(130, 30, 200, 25);
        add(txtId);

        JButton btnCurtir = new JButton("Curtir");
        btnCurtir.setBounds(70, 80, 100, 30);
        add(btnCurtir);

        JButton btnDescurtir = new JButton("Descurtir");
        btnDescurtir.setBounds(200, 80, 100, 30);
        add(btnDescurtir);

        btnCurtir.addActionListener(e -> {
            try {
                int idMusica = Integer.parseInt(txtId.getText().trim());
                if (dao.curtir(usuario.getEmail(), idMusica)) {
                    JOptionPane.showMessageDialog(this, "Curtido com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(this, "Já estava curtido.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        btnDescurtir.addActionListener(e -> {
            try {
                int idMusica = Integer.parseInt(txtId.getText().trim());
                if (dao.descurtir(usuario.getEmail(), idMusica)) {
                    JOptionPane.showMessageDialog(this, "Descurtido.");
                    new HistoricoDAO().registrarDescurtida(usuario.getEmail(), idMusica);
                } else {
                    JOptionPane.showMessageDialog(this, "Essa música não estava curtida.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });
    }
}