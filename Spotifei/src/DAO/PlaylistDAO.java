/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Gustavo
 */


import model.Playlist;
import java.sql.*;
import java.util.*;

public class PlaylistDAO {
    private static Conexao conexao = new Conexao();

    public boolean criarPlaylist(String nome, String emailUsuario) {
        String sql = "INSERT INTO playlists (nome, email_usuario) VALUES (?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, emailUsuario);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Playlist> listarPlaylists(String emailUsuario) {
        List<Playlist> lista = new ArrayList<>();
        String sql = "SELECT * FROM playlists WHERE email_usuario = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Playlist(rs.getInt("id"), rs.getString("nome"), rs.getString("email_usuario")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean renomearPlaylist(int idPlaylist, String novoNome) {
        String sql = "UPDATE playlists SET nome = ? WHERE id = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, idPlaylist);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean excluirPlaylist(int idPlaylist) {
        try (Connection conn = conexao.getConnection()) {
            // Remove músicas da playlist primeiro
            PreparedStatement delMusicas = conn.prepareStatement("DELETE FROM playlist_musicas WHERE id_playlist = ?");
            delMusicas.setInt(1, idPlaylist);
            delMusicas.executeUpdate();

            PreparedStatement delPlaylist = conn.prepareStatement("DELETE FROM playlists WHERE id = ?");
            delPlaylist.setInt(1, idPlaylist);
            delPlaylist.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean adicionarMusica(int idPlaylist, int idMusica) {
        String sql = "INSERT INTO playlist_musicas (id_playlist, id_musica) VALUES (?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean removerMusica(int idPlaylist, int idMusica) {
        String sql = "DELETE FROM playlist_musicas WHERE id_playlist = ? AND id_musica = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPlaylist);
            stmt.setInt(2, idMusica);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Integer> listarIdsMusicasDaPlaylist(int idPlaylist) {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id_musica FROM playlist_musicas WHERE id_playlist = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPlaylist);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id_musica"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
