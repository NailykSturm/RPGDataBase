package view.common;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

import model.main.StartApp;
import model.rpg.RPGControler;
import view.main.WelcomePanel;

/**
 * Application main frame
 * 
 * @author NailykSturm
 */
public class AppWindow extends JFrame {

    /** Controler of the rpgs */
    private RPGControler rpgControler;

    /**
     * Constructor of the class
     * @param rpgControler the rpgs's controler
     */
    public AppWindow(RPGControler rpgControler) {
        this.rpgControler = rpgControler;
        setTitle("RPG script planner tool");
        setSize(StartApp.screenSize);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        WelcomePanel welcomePanel = new WelcomePanel();
        MenuPanel menu = new MenuPanel(this);

        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.NORTH);
        this.add(welcomePanel, BorderLayout.CENTER);
    }

    /**
     * Getter of the rpgControler
     * @return the rpgControler
     */
    public RPGControler getRpg() {
        return rpgControler;
    }

    /**
     * Function that used to change the main panel to show to the user
     * @param newPanel the new panel to show
     */
    public void changeView(JComponent newPanel) {
        this.getContentPane().removeAll();
        MenuPanel menu = new MenuPanel(this);
        this.getContentPane().add(menu, BorderLayout.NORTH);
        this.getContentPane().add(newPanel, BorderLayout.CENTER);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
