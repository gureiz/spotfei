/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Gustavo
 */
import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    private static UsuarioDAO dao = new UsuarioDAO();

    public static boolean cadastrar(String nome, String email, String senha) {
        Usuario u = new Usuario(nome, email, senha);
        return dao.cadastrar(u);
    }

    public static Usuario login(String email, String senha) {
        return dao.autenticar(email, senha);
    }
}