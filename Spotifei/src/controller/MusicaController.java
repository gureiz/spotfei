/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Gustavo
 */
import DAO.MusicaDAO;
import model.Musica;
import java.util.List;

import model.Musica;
import java.util.List;

public class MusicaController {
    private static MusicaDAO DAO = new MusicaDAO();

    public static List<Musica> buscar(String termo) {
        return DAO.buscar(termo);
    }
}