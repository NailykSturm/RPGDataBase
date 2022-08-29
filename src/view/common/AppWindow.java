package view.common;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.main.StartApp;
import model.rpg.RPGControler;
import view.main.WelcomePanel;

/*
 * Application main frame
 */
public class AppWindow extends JFrame {

    private RPGControler rpgControler;

    // Constructor
    public AppWindow(RPGControler rpgControler) {
        this.rpgControler = rpgControler;
        setTitle("RPG script planner tool");
        setSize(StartApp.screenSize);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        WelcomePanel welcomePanel = new WelcomePanel(this);
        this.setContentPane(welcomePanel);
    }

    public RPGControler getRpg() {
        return rpgControler;
    }

    public void changeView(JPanel newPanel) {
        this.getContentPane().removeAll();
        this.getContentPane().add(newPanel);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
}
