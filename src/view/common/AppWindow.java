package view.common;

import javax.swing.JFrame;
import javax.swing.JPanel;

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

        WelcomePanel welcomePanel = new WelcomePanel(this);
        this.setContentPane(welcomePanel);
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
    public void changeView(JPanel newPanel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(newPanel);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
