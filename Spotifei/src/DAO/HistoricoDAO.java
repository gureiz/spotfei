/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Gustavo
 */
import model.Musica;
import java.sql.*;
import java.util.*;

public class HistoricoDAO {
    private static Conexao conexao = new Conexao();

    public void registrarBusca(String emailUsuario, int idMusica) {
        String sql = "INSERT INTO historico_buscas (email_usuario, id_musica) VALUES (?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailUsuario);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarDescurtida(String emailUsuario, int idMusica) {
        String sql = "INSERT INTO historico_descurtidas (email_usuario, id_musica) VALUES (?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailUsuario);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Musica> getUltimasBuscas(String emailUsuario) {
        List<Musica> lista = new ArrayList<>();
        String sql = """
            SELECT m.* FROM historico_buscas hb
            JOIN musicas m ON hb.id_musica = m.id
            WHERE hb.email_usuario = ?
            ORDER BY hb.data_busca DESC
            LIMIT 10
        """;
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Musica(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("artista"),
                    rs.getString("genero")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Musica> getDescurtidas(String emailUsuario) {
        List<Musica> lista = new ArrayList<>();
        String sql = """
            SELECT m.* FROM historico_descurtidas hd
            JOIN musicas m ON hd.id_musica = m.id
            WHERE hd.email_usuario = ?
            ORDER BY hd.data_descurtada DESC
            LIMIT 10
        """;
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Musica(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("artista"),
                    rs.getString("genero")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}