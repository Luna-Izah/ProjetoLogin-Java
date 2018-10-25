package br.com.adrianob.controller;

import br.com.adrianob.dao.DaoUsuario;
import br.com.adrianob.model.Usuario;
import br.com.adrianob.service.Conexao;
import br.com.adrianob.view.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author drink
 */
public class LoginController implements ActionListener {

    private LoginView lv;
    private DaoUsuario du;

    public LoginController() {
        Connection conn = Conexao.getInstance().getConn();
        du = new DaoUsuario(conn);
        lv = new LoginView(this);
        lv.abrir();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equalsIgnoreCase("sair")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("logar")) {
            autenticar();
        }
    }

    private void autenticar() {
        String login = lv.getLogin();
        String senha = lv.getSenha();
        if (login.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(lv, "Usuário e senha são obrigatórios");
            return;
        }
        Usuario usuario = null;
        try {
            usuario = this.du.getUsuario(login, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(lv, "Algo Aconteceu!" + ex.getMessage());
        }
        if (usuario == null) {
            JOptionPane.showMessageDialog(lv, "Usuário não encontrado!");
            return;
        }
        if (!usuario.getStatus().equals("A")) {
            JOptionPane.showMessageDialog(lv, "Acesso negado! a conta não está Ativa " + usuario.getNome() + "!");
            return;
        }
        /// chamar o controller de Menu
        ControllerMenu menu = new ControllerMenu(usuario);
        menu.abreMenu();
        lv.dispose();
    }
}
