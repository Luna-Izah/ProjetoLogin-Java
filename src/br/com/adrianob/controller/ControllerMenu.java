package br.com.adrianob.controller;

import br.com.adrianob.model.Usuario;
import br.com.adrianob.view.MenuView;
import br.com.adrianob.view.TelaInterna;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author drink
 */
public class ControllerMenu implements ActionListener {

    private MenuView tela;
    private Usuario logado;

    public ControllerMenu(Usuario u) {
        this.logado = u;
        this.tela = new MenuView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaInterna teli = new TelaInterna();
        this.tela.getAreaDeTrabalho().add(teli);
        teli.setVisible(true);
       teli.setSize(new Dimension(300,200));
    }

    public void abreMenu() {
        this.tela.setVisible(true);
        this.tela.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.tela.getPnStatus().add(new JLabel("Usuário: " + this.logado.getNome()));

        this.tela.getPnStatus().add(new JLabel(new Date().toString()));

    }

}
