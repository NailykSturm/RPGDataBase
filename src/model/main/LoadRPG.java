package model.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JMenu;

import view.main.ErrorMenu;
import view.main.ListRPG;
import view.main.MenuWithoutRPG;

public class LoadRPG {

    JMenu rpgMenu;

    public LoadRPG() {
        ObjectInputStream ois_rpg;
        
        try {
            ois_rpg = new ObjectInputStream(new FileInputStream(StartApp.RPG_FILE));
            rpgMenu = new ListRPG((RPG) ois_rpg.readObject());

        } catch (FileNotFoundException eFNF) {
            System.out.println("Error append when loading => File not found");
            rpgMenu = new MenuWithoutRPG().getMenu();
        } catch (IOException eIO) {
            System.out.println("Error append when loading => IOException");
            eIO.printStackTrace();
            rpgMenu = new ErrorMenu("Error append when loading => IOException").getMenu();
        } catch (ClassNotFoundException eCNFE) {
            System.out.println("Error append when loading => Class not found");
            eCNFE.printStackTrace();
            rpgMenu = new ErrorMenu("Error append when loading => Class not found").getMenu();
        }
    }

    public JMenu getMenu() {
        return rpgMenu;
    }

}
