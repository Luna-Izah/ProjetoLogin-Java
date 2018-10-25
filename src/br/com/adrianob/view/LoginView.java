/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adrianob.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author drink
 */
public class LoginView extends JFrame {

    private JTextField login;
    private JPasswordField senha;
    private ActionListener al;

    public LoginView(ActionListener al) {
        super("Tela de login");
        this.al = al;
        init();
    }

    private void init() {
        this.setLayout(new GridLayout(0, 2));
        login = new JTextField();
        senha = new JPasswordField();
        this.getContentPane().add(new JLabel("Login"));
        this.getContentPane().add(login);
        this.getContentPane().add(new JLabel("Senha"));
        this.getContentPane().add(senha);
        JButton btnSair = new JButton("Sair");
        btnSair.setActionCommand("sair");
        JButton btnLogar = new JButton("Logar");
        btnLogar.setActionCommand("logar");
        this.getContentPane().add(btnSair);
        this.getContentPane().add(btnLogar);
        btnSair.addActionListener(al);
        btnLogar.addActionListener(al);
        this.pack();
        this.setSize(new Dimension(500, 300));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    public String getLogin() {
        return this.login.getText().trim().toLowerCase();
    }

    public String getSenha() {
        String pw = new String(senha.getPassword());
        return pw.trim();
    }

    public void abrir() {
        this.setVisible(true);
    }

}
