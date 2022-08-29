package model.rpg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.main.StartApp;

/**
 * Class who load the RPGs from the save file
 */
public class LoadRPG {

    public static RPGControler loadRPGFromSave() {
        ObjectInputStream ois_rpg;
        RPGControler rpgControler;

        try {
            ois_rpg = new ObjectInputStream(new FileInputStream(StartApp.FOLDER + StartApp.RPG_FILE + StartApp.EXTENSION));
            rpgControler = (RPGControler) ois_rpg.readObject();
            rpgControler.checkIfEverythingIsLoaded();
            ois_rpg.close();
        } catch (FileNotFoundException eFNF) {
            System.out.println("Error append when loading RPGControler => File not found");
            rpgControler = new RPGControler();
        } catch (IOException eIO) {
            System.out.println("Error append when loading RPGControler => IOException");
            rpgControler = new RPGControler();
            eIO.printStackTrace();
        } catch (ClassNotFoundException eCNFE) {
            System.out.println("Error append when loading RPGControler => Class not found");
            rpgControler = new RPGControler();
            eCNFE.printStackTrace();
        }

        return rpgControler;
    }
}
