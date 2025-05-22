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
    private int id;
    private String nome;
    private String artista;
    private String genero;

    public Musica(int id, String nome, String artista, String genero) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
        this.genero = genero;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getArtista() { return artista; }
    public String getGenero() { return genero; }
}