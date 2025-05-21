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
import model.Musica;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaVisualizarHistorico extends JFrame {
    private Usuario usuario;

    public TelaVisualizarHistorico(Usuario usuario) {
        this.usuario = usuario;
        setTitle("Histórico do Usuário");
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        StringBuilder sb = new StringBuilder();
        HistoricoDAO dao = new HistoricoDAO();

        sb.append("🕐 Últimas 10 buscas:\n");
        List<Musica> buscas = dao.getUltimasBuscas(usuario.getEmail());
        if (buscas.isEmpty()) sb.append("Nenhuma busca registrada.\n");
        for (Musica m : buscas) {
            sb.append("• ").append(m.getId()).append(" - ").append(m.getNome())
              .append(" (").append(m.getArtista()).append(")\n");
        }

        sb.append("\n❤️ Músicas curtidas:\n");
        List<Musica> curtidas = new UsuarioDAO().listarMusicasCurtidas(usuario.getEmail());
        if (curtidas.isEmpty()) sb.append("Nenhuma curtida registrada.\n");
        for (Musica m : curtidas) {
            sb.append("• ").append(m.getId()).append(" - ").append(m.getNome())
              .append(" (").append(m.getArtista()).append(")\n");
        }

        sb.append("\n💔 Músicas descurtidas:\n");
        List<Musica> descurtidas = dao.getDescurtidas(usuario.getEmail());
        if (descurtidas.isEmpty()) sb.append("Nenhuma descurtida registrada.\n");
        for (Musica m : descurtidas) {
            sb.append("• ").append(m.getId()).append(" - ").append(m.getNome())
              .append(" (").append(m.getArtista()).append(")\n");
        }

        area.setText(sb.toString());
        add(scroll, BorderLayout.CENTER);
    }
}