/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo
 */

import java.util.ArrayList;
import java.util.List;

public class Artista extends Pessoa {
    private List<Musica> musicas = new ArrayList<>();

    public Artista(String nome, String email) {
        super(nome, email);
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}