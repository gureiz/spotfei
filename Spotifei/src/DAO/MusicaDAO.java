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
import java.util.ArrayList;
import java.util.List;


public class MusicaDAO {
    private Conexao conexao = new Conexao();

    public List<Musica> buscar(String termo) {
        List<Musica> lista = new ArrayList<>();
        String sql = "SELECT * FROM musicas WHERE LOWER(nome) LIKE ? OR LOWER(artista) LIKE ? OR LOWER(genero) LIKE ?";
        try (Connection conn = conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String query = "%" + termo.toLowerCase() + "%";
            stmt.setString(1, query);
            stmt.setString(2, query);
            stmt.setString(3, query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Musica(
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