/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Gustavo
 */

import model.Usuario;
import java.sql.*;
import model.Musica;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static Conexao conexao = new Conexao();


    public boolean cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios(nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static Usuario autenticar(String email, String senha) {
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getString("nome"), email, senha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean curtir(String emailUsuario, int idMusica) {
    String sql = "INSERT INTO curtidas (email_usuario, id_musica) VALUES (?, ?) ON CONFLICT DO NOTHING";
    try (Connection conn = conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, emailUsuario);
        stmt.setInt(2, idMusica);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        return false;
    }
}

    public boolean descurtir(String emailUsuario, int idMusica) {
        String sql = "DELETE FROM curtidas WHERE email_usuario = ? AND id_musica = ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailUsuario);
            stmt.setInt(2, idMusica);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    public List<Musica> listarMusicasCurtidas(String emailUsuario) {
    List<Musica> lista = new ArrayList<>();
    String sql = """
        SELECT m.* FROM curtidas c
        JOIN musicas m ON c.id_musica = m.id
        WHERE c.email_usuario = ?
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