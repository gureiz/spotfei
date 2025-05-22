/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Gustavo
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DAO.Conexao;

public class CurtidaDAO {
    private Conexao conexao = new Conexao();

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
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
