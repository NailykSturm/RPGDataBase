package model.rpg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.main.StartApp;

public class SaveRPG {

    public static void saveRPGToFile(RPGControler rpgControler) {
        try {
            ObjectOutputStream oos_rpg = new ObjectOutputStream(new FileOutputStream(StartApp.FOLDER + StartApp.RPG_FILE + StartApp.EXTENSION));
            oos_rpg.writeObject(rpgControler);
            oos_rpg.close();
            System.out.println("Saving RPG done");
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }
}
