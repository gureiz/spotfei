/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Gustavo
 */


import DAO.CurtidaDAO;

public class CurtidaController {
    private static CurtidaDAO dao = new CurtidaDAO();

    public static boolean curtir(String emailUsuario, int idMusica) {
        return dao.curtir(emailUsuario, idMusica);
    }

    public static boolean descurtir(String emailUsuario, int idMusica) {
        return dao.descurtir(emailUsuario, idMusica);
    }
}
