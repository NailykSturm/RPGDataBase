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

    public static RPGControler loadRPGFromSave(RPGControler rpgControler) {
        ObjectInputStream ois_rpg;

        try {
            ois_rpg = new ObjectInputStream(new FileInputStream(StartApp.FOLDER + StartApp.RPG_FILE));
            rpgControler = (RPGControler) ois_rpg.readObject();


            ois_rpg.close();
            System.out.println("Loading RPG done");
        } catch (FileNotFoundException eFNF) {
            System.out.println("Error append when loading => File not found");
        } catch (IOException eIO) {
            System.out.println("Error append when loading => IOException");
            eIO.printStackTrace();
        } catch (ClassNotFoundException eCNFE) {
            System.out.println("Error append when loading => Class not found");
            eCNFE.printStackTrace();
        }

        return rpgControler;
    }
}
