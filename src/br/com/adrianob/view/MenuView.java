package br.com.adrianob.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author drink
 */
public class MenuView extends JFrame {
    
    private JMenuBar meuMenu;
    private JDesktopPane areaDeTrabalho;
    private JPanel pnStatus;
    private ActionListener al;
    
    public MenuView(ActionListener al) {
        super("Tela Principal");
        this.al = al;
        this.montarTela();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void montarTela() {
        meuMenu = new JMenuBar();
        areaDeTrabalho = new JDesktopPane();
        areaDeTrabalho.setBackground(Color.DARK_GRAY);
        pnStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        this.getContentPane().add(meuMenu, BorderLayout.NORTH);
        //this.setJMenuBar(meuMenu);
        this.getContentPane().add(areaDeTrabalho, BorderLayout.CENTER);
        this.getContentPane().add(pnStatus, BorderLayout.SOUTH);
        
        JMenu cadastros = new JMenu("Cadastros");
        
        JMenuItem cadPessoa = new JMenuItem("Pessoa");
        cadPessoa.addActionListener(al);
        cadastros.add(cadPessoa);
        meuMenu.add(cadastros);
        
    }
    
    public JPanel getPnStatus() {
        return pnStatus;
    }

    public JDesktopPane getAreaDeTrabalho() {
        return areaDeTrabalho;
    }
    
    
}
