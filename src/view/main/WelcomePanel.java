package view.main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.main.LoadRPG;

/*
 * Welcome panel of the application
 * Contains a welcome message and a button to choose workspace
 */
public class WelcomePanel extends JPanel {

    // Constructor
    public WelcomePanel() {
        setLayout(new BorderLayout());

        // Menu bar
        this.add(menu(), BorderLayout.NORTH);

        // Welcome message
        this.add(message(), BorderLayout.CENTER);
    }

    // ======= Elements =======
    // Menu bar
    private JPanel menu() {
        JPanel menuPanel = new JPanel();
        JMenu menu = new JMenu("Menu");
        JMenu changeDBMenu = new LoadRPG().getMenu();
        
        menu.add(changeDBMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        menuPanel.setLayout(new BorderLayout());
        menuPanel.add(menuBar, BorderLayout.WEST);

        return menuPanel;
    }

    // Welcome message
    private JPanel message() {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        
        messagePanel.add(new JLabel("Welcome to the script planning tool for RPG's game"), BorderLayout.CENTER);
        messagePanel.add(new JLabel("Created by Nailyk Sturm"), BorderLayout.SOUTH);

        return messagePanel;
    }

}
