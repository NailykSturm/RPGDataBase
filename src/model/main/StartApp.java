package model.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import view.common.AppWindow;

/*
 * Application Main class
 */
public class StartApp {

    // Get screen size
    public final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    // Name of the save file
    public final static String RPG_FILE = "rpg.rpgdb";
    public final static String BESTIARY_FILE = "bestiary.rpgdb";
    public final static String SCRIPT_FILE = "script.rpgdb";
    public final static String NOTEBLOC_FILE = "notebloc.rpgdb";

    // Constructor
    public static void main(String[] args) {
        AppWindow welcolmeFrame = new AppWindow();
        welcolmeFrame.setVisible(true);
    }

}
