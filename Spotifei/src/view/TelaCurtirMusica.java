/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */
import controller.CurtidaController;
import model.Usuario;

import javax.swing.*;

public class TelaCurtirMusica extends JFrame {
    public TelaCurtirMusica(Usuario usuario) {
        setTitle("Curtir/Descurtir Música");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblIdMusica = new JLabel("ID da música:");
        lblIdMusica.setBounds(20, 20, 120, 25);
        JTextField txtIdMusica = new JTextField();
        txtIdMusica.setBounds(150, 20, 200, 25);

        JButton btnCurtir = new JButton("Curtir");
        btnCurtir.setBounds(80, 70, 100, 30);

        JButton btnDescurtir = new JButton("Descurtir");
        btnDescurtir.setBounds(200, 70, 100, 30);

        btnCurtir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtIdMusica.getText());
                if (CurtidaController.curtir(usuario.getEmail(), id)) {
                    JOptionPane.showMessageDialog(this, "Música curtida!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao curtir a música.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        btnDescurtir.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtIdMusica.getText());
                if (CurtidaController.descurtir(usuario.getEmail(), id)) {
                    JOptionPane.showMessageDialog(this, "Música descurtida.");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao descurtir a música.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        add(lblIdMusica);
        add(txtIdMusica);
        add(btnCurtir);
        add(btnDescurtir);
    }
}
