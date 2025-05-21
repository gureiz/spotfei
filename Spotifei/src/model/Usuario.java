/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo
 */


public class Usuario extends Pessoa implements Autenticacao {
    private String senha;

    public Usuario(String nome, String email, String senha) {
        super(nome, email);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
}