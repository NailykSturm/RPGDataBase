package view.main;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.common.AppWindow;
import view.common.MenuPanel;

/**
 * Welcome panel of the application
 * Contains a welcome message and a button to choose workspace
 * 
 * @author NailykSturm
 */
public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private AppWindow appWindow;

    /**
     * Constructor of the class
     * @param mainWindow main window of the application
     */
    public WelcomePanel(AppWindow mainWindow) {
        this.appWindow = mainWindow;
        setLayout(new BorderLayout());

        // Menu bar
        this.add(new MenuPanel(appWindow), BorderLayout.NORTH);

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
