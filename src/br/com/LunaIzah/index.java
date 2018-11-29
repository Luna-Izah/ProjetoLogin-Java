package br.com.LunaIzah;

import Controller.UserController;
import java.sql.Connection;
import javax.swing.JFrame;

public class index extends JFrame {

    /**
     * @param args the command line arguments
     * @param conn
     */
    public static void main(String[] args, Connection conn) {

        UserController uc = new UserController(conn); 

    }
    
}