package view.main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Welcome panel of the application
 * Contains a welcome message and a button to choose workspace
 * 
 * @author NailykSturm
 */
public class WelcomePanel extends JPanel {

    /**
     * Constructor of the class
     * @param mainWindow main window of the application
     */
    public WelcomePanel() {
        setLayout(new BorderLayout());

        // Welcome message
        this.add(message(), BorderLayout.CENTER);
    }

    // ======= Elements =======

    /**
     * Function that create a welcome message for the user
     * @return the JPanel created
     */
    private JPanel message() {
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());

        messagePanel.add(new JLabel("Welcome to the script planning tool for RPG's game"), BorderLayout.CENTER);
        messagePanel.add(new JLabel("Created by Nailyk Sturm"), BorderLayout.SOUTH);

        return messagePanel;
    }

}
