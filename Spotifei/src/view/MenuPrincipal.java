/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Gustavo
 */

import model.Usuario;
import javax.swing.*;
import view.TelaBuscarMusica;
import view.TelaCurtirMusica;
import view.TelaGerenciarPlaylists;


public class MenuPrincipal extends JFrame {
    public MenuPrincipal(Usuario usuario) {
        setTitle("Spotifei - Menu Principal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo, " + usuario.getNome() + "!");
        lblBemVindo.setBounds(20, 20, 300, 25);

        JButton btnBuscar = new JButton("Buscar músicas");
        btnBuscar.setBounds(100, 60, 200, 30);

        //JButton btnListar = new JButton("Listar músicas encontradas");
        //btnListar.setBounds(100, 100, 200, 30);

        JButton btnCurtir = new JButton("Curtir/Descurtir músicas");
        btnCurtir.setBounds(100, 100, 200, 30);

        JButton btnPlaylists = new JButton("Gerenciar playlists");
        btnPlaylists.setBounds(100, 140, 200, 30);

        JButton btnHistorico = new JButton("Visualizar histórico");
        btnHistorico.setBounds(100, 180, 200, 30);

        btnBuscar.addActionListener(e -> new TelaBuscarMusica(usuario).setVisible(true));
        

        btnCurtir.addActionListener(e -> new TelaCurtirMusica(usuario).setVisible(true));

        
        //btnHistorico.addActionListener(e -> new TelaVisualizarCurtidas(usuario).setVisible(true));

        btnPlaylists.addActionListener(e -> new TelaGerenciarPlaylists(usuario).setVisible(true));
        
        btnHistorico.addActionListener(e -> new TelaVisualizarHistorico(usuario).setVisible(true));



        add(lblBemVindo);
        add(btnBuscar);
        //add(btnListar);
        add(btnCurtir);
        add(btnPlaylists);
        add(btnHistorico);
    }
}

      