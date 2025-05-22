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
import DAO.HistoricoDAO;
import model.Musica;
import model.Usuario;

import javax.swing.*;
import java.util.List;

public class TelaBuscarMusica extends JFrame {
    private Usuario usuario;

    public TelaBuscarMusica(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Buscar Músicas");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null); // layout manual

        JLabel lblBuscar = new JLabel("Buscar:");
        lblBuscar.setBounds(20, 20, 80, 25);
        add(lblBuscar);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(100, 20, 250, 25);
        add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(360, 20, 100, 25);
        add(btnBuscar);

        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);
        scroll.setBounds(20, 60, 440, 380);
        add(scroll);

        btnBuscar.addActionListener(e -> {
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
                    resultado.append("ID: " + m.getId() + "\n");
                    resultado.append("🎵 Nome: " + m.getNome() + "\n");
                    resultado.append("👤 Artista: " + m.getArtista() + "\n");
                    resultado.append("🎧 Gênero: " + m.getGenero() + "\n");
                    resultado.append("---------------------------\n");

                    // grava no histórico de buscas do banco
                    new HistoricoDAO().registrarBusca(usuario.getEmail(), m.getId());
                }
            }
        });
    }
}