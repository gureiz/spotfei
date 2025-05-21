/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */
import controller.MusicaController;
import model.Musica;
import javax.swing.*;

import java.util.List;




public class TelaBuscarMusica extends JFrame {
    private JTextField txtBuscar;
    private JTextArea resultado;

    public TelaBuscarMusica() {
        setTitle("Buscar Músicas");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null); // manual layout

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(20, 20, 60, 25);
        add(lblBuscar);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(80, 20, 300, 25);
        add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(390, 20, 80, 25);
        add(btnBuscar);

        resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);
        scroll.setBounds(20, 60, 450, 380);
        add(scroll);

        btnBuscar.addActionListener(e -> buscarMusicas());
    }

    private void buscarMusicas() {
        String termo = txtBuscar.getText().trim();
        resultado.setText("");

        if (termo.isEmpty()) {
            resultado.setText("Digite algo para buscar.");
            return;
        }

        List<Musica> musicas = MusicaController.buscar(termo);
        if (musicas.isEmpty()) {
            resultado.setText("Nenhuma música encontrada.");
        } else {
            for (Musica m : musicas) {
                resultado.append("🎵 Nome: " + m.getNome() + "\n");
                resultado.append("👤 Artista: " + m.getArtista() + "\n");
                resultado.append("🎧 Gênero: " + m.getGenero() + "\n");
                resultado.append("------------------------------\n");
            }
        }
    }
}
