/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */
import DAO.MusicaDAO;
import DAO.PlaylistDAO;
import model.Musica;
import model.Playlist;

import javax.swing.*;
import java.util.List;

public class TelaMusicasDaPlaylist extends JFrame {
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    private MusicaDAO musicaDAO = new MusicaDAO();
    private Playlist playlist;
    private JTextArea resultado;

    public TelaMusicasDaPlaylist(Playlist playlist) {
        this.playlist = playlist;
        setTitle("Músicas da Playlist: " + playlist.getNome());
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JLabel lblId = new JLabel("ID da música:");
        lblId.setBounds(20, 20, 100, 25);
        JTextField txtId = new JTextField();
        txtId.setBounds(120, 20, 100, 25);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(230, 20, 100, 25);

        JButton btnRemover = new JButton("Remover");
        btnRemover.setBounds(340, 20, 100, 25);

        resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);
        scroll.setBounds(20, 60, 440, 370);

        add(lblId);
        add(txtId);
        add(btnAdicionar);
        add(btnRemover);
        add(scroll);

        atualizarLista();

        btnAdicionar.addActionListener(e -> {
            try {
                int idMusica = Integer.parseInt(txtId.getText());
                playlistDAO.adicionarMusica(playlist.getId(), idMusica);
                atualizarLista();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });

        btnRemover.addActionListener(e -> {
            try {
                int idMusica = Integer.parseInt(txtId.getText());
                playlistDAO.removerMusica(playlist.getId(), idMusica);
                atualizarLista();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.");
            }
        });
    }

    private void atualizarLista() {
        resultado.setText("");
        List<Integer> ids = playlistDAO.listarIdsMusicasDaPlaylist(playlist.getId());
        for (Integer id : ids) {
            Musica m = musicaDAO.buscarPorId(id);
            if (m != null) {
                resultado.append("ID: " + m.getId() + "\n");
                resultado.append("🎵 " + m.getNome() + "\n");
                resultado.append("👤 " + m.getArtista() + "\n");
                resultado.append("🎧 " + m.getGenero() + "\n");
                resultado.append("----------------------\n");
            }
        }
    }
}