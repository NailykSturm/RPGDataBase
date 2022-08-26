package view.common;

import javax.swing.JFrame;
import model.main.StartApp;
import view.main.WelcomePanel;

/*
 * Application main frame
 */
public class AppWindow extends JFrame {

    // Constructor
    public AppWindow() {
        setTitle("RPG script planner tool");
        setSize(StartApp.screenSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WelcomePanel welcomePanel = new WelcomePanel();
        this.setContentPane(welcomePanel);
    }

}
