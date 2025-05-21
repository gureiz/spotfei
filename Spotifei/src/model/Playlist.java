/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo
 */
public class Playlist {
    private int id;
    private String nome;
    private String emailUsuario;

    public Playlist(int id, String nome, String emailUsuario) {
        this.id = id;
        this.nome = nome;
        this.emailUsuario = emailUsuario;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmailUsuario() { return emailUsuario; }
    
    @Override
    public String toString() {
        return nome;
}
}