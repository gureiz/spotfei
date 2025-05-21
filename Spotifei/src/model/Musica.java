/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo
 */
public class Musica {
    private String nome;
    private String artista;
    private String genero;

    public Musica(String nome, String artista, String genero) {
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
    }

    public String getNome() { return nome; }
    public String getArtista() { return artista; }
    public String getGenero() { return genero; }
}