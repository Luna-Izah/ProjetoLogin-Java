package br.com.adrianob.dao;

import br.com.adrianob.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author drink
 */
public class DaoUsuario {

    private Connection conn;

    public DaoUsuario(Connection conn) {
        this.conn = conn;
    }

    public Usuario getUsuario(String login, String senha) throws SQLException {
        String sql = "select * from usuario where login = ?"
                + " and senha = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.first()) {
            Usuario usu = new Usuario();
            usu.setId(rs.getLong("id"));
            usu.setNome(rs.getString("nome"));
            usu.setLogin(rs.getString("login"));
            usu.setSenha(rs.getString("senha"));
            usu.setStatus(rs.getString("status"));
            return usu;
        }
        return null;
    }

}
