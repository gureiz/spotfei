/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */
import DAO.PlaylistDAO;
import model.Playlist;
import model.Usuario;

import javax.swing.*;
import java.util.List;

public class TelaGerenciarPlaylists extends JFrame {
    private Usuario usuario;
    private PlaylistDAO dao = new PlaylistDAO();
    private DefaultListModel<Playlist> modeloLista = new DefaultListModel<>();
    private JList<Playlist> lista;

    public TelaGerenciarPlaylists(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Gerenciar Playlists");
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(20, 20, 340, 180);

        JButton btnCriar = new JButton("Criar");
        btnCriar.setBounds(20, 210, 100, 25);
        JButton btnEditar = new JButton("Renomear");
        btnEditar.setBounds(130, 210, 100, 25);
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(240, 210, 100, 25);
        JButton btnGerenciarMusicas = new JButton("Editar");
        btnGerenciarMusicas.setBounds(130, 250, 120, 25);

        add(scroll);
        add(btnCriar);
        add(btnEditar);
        add(btnExcluir);
        add(btnGerenciarMusicas);

        carregarPlaylists();

        btnCriar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome da nova playlist:");
            if (nome != null && !nome.isEmpty()) {
                dao.criarPlaylist(nome, usuario.getEmail());
                carregarPlaylists();
            }
        });

        btnEditar.addActionListener(e -> {
            Playlist p = lista.getSelectedValue();
            if (p != null) {
                String novoNome = JOptionPane.showInputDialog("Novo nome:", p.getNome());
                if (novoNome != null && !novoNome.isEmpty()) {
                    dao.renomearPlaylist(p.getId(), novoNome);
                    carregarPlaylists();
                }
            }
        });

        btnExcluir.addActionListener(e -> {
            Playlist p = lista.getSelectedValue();
            if (p != null && JOptionPane.showConfirmDialog(this, "Excluir a playlist?") == 0) {
                dao.excluirPlaylist(p.getId());
                carregarPlaylists();
            }
        });

        btnGerenciarMusicas.addActionListener(e -> {
            Playlist p = lista.getSelectedValue();
            if (p != null) {
                new TelaMusicasDaPlaylist(p).setVisible(true);
            }
        });
    }

    private void carregarPlaylists() {
        modeloLista.clear();
        List<Playlist> playlists = dao.listarPlaylists(usuario.getEmail());
        for (Playlist p : playlists) {
            modeloLista.addElement(p);
        }
    }
}
