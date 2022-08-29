package model.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import model.rpg.LoadRPG;
import model.rpg.RPGControler;
import view.common.AppWindow;

/**
 * Application Main class
 * @author NailykSturm
 */
public class StartApp {


    // Get screen size
    public final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /** Extension of the files */
    public final static String EXTENSION = ".rpgdb";

    /** Location of the main folder to save files*/
    public final static String FOLDER = "./saves/";
    /** Location of the folder to save bestiary's form templates*/
    public final static String FOLDER_TEMPLATE = "/template/";

    /** Name of the list of RPG */
    public final static String RPG_FILE = "rpg";
    /** Name of one RPG's save file */
    public final static String RPG_INFO_FILE = "info";

    /** Name of the bestiary's save file */
    public final static String BESTIARY_FILE = "bestiary";
    /** Name of the bestiary's template form save file */
    public final static String BESTIARY_TEMPLATE_FILE = "template";

    /** Name of the script's save file */
    public final static String SCRIPT_FILE = "script";

    /** Name of the notebloc's save file */
    public final static String NOTEBLOC_FILE = "notebloc";

    // Constructor
    public static void main(String[] args) {
        RPGControler rpgControler = new RPGControler();
        rpgControler = LoadRPG.loadRPGFromSave(rpgControler);
        AppWindow welcolmeFrame = new AppWindow(rpgControler);
        welcolmeFrame.setVisible(true);
    }
}
