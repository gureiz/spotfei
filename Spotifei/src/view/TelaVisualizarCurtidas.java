/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */

import DAO.Conexao;
import model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TelaVisualizarCurtidas extends JFrame {
    public TelaVisualizarCurtidas(Usuario usuario) {
        setTitle("Músicas Curtidas");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);

        add(scroll, BorderLayout.CENTER);

        try (Connection conn = new Conexao().getConnection()) {
            String sql = "SELECT m.id, m.nome, m.artista, m.genero FROM musicas m " +
                         "INNER JOIN curtidas c ON m.id = c.id_musica WHERE c.email_usuario = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                area.append("ID: " + rs.getInt("id") + "\n");
                area.append("Nome: " + rs.getString("nome") + "\n");
                area.append("Artista: " + rs.getString("artista") + "\n");
                area.append("Gênero: " + rs.getString("genero") + "\n");
                area.append("----------------------------\n");
            }

            if (!rs.isBeforeFirst()) {
                area.setText("Você ainda não curtiu nenhuma música.");
            }

        } catch (SQLException e) {
            area.setText("Erro ao carregar músicas curtidas.");
        }
    }
}