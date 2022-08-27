package view.main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.common.AppWindow;
import view.common.MenuPanel;

/*
 * Welcome panel of the application
 * Contains a welcome message and a button to choose workspace
 */
public class WelcomePanel extends JPanel {

    private AppWindow appWindow;

    // Constructor
    public WelcomePanel(AppWindow mainWindow) {
        this.appWindow = mainWindow;
        setLayout(new BorderLayout());

        // Menu bar
        this.add(new MenuPanel(appWindow), BorderLayout.NORTH);

        // Welcome message
        this.add(message(), BorderLayout.CENTER);
    }

    // ======= Elements =======

    // Welcome message
    private JPanel message() {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        
        messagePanel.add(new JLabel("Welcome to the script planning tool for RPG's game"), BorderLayout.CENTER);
        messagePanel.add(new JLabel("Created by Nailyk Sturm"), BorderLayout.SOUTH);

        return messagePanel;
    }

}
