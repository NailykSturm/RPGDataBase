package model.bestiary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.main.StartApp;
import model.rpg.RPGInfo;

public class SaveBestiary {

    /**
     * Save the bestiary into a file
     */
    public static void saveBestiaryTofile(ArrayList<BestiaryEntity> bestiary, RPGInfo rpg) {
        try {
            ObjectOutputStream oos_entity = new ObjectOutputStream(new FileOutputStream(
                    StartApp.FOLDER + StartApp.BESTIARY_FILE + StartApp.BESTIARY_ENTITY + "_" + rpg.getName()
                            + StartApp.EXTENSION));
            oos_entity.writeObject(bestiary);
            oos_entity.close();
            System.out.println("Saving bestiary of " + rpg.getName() + " done");
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }

    /**
     * Save the actual Form into a file
     */
    public static void saveBestiaryFormToFile(BestiaryForm bestiaryForm, RPGInfo rpg) {
        try {
            ObjectOutputStream oos_rpg = new ObjectOutputStream(new FileOutputStream(
                    StartApp.FOLDER + StartApp.BESTIARY_FILE + "_" + StartApp.BESTIARY_FORM_FILE + "_" + rpg.getName()
                            + StartApp.EXTENSION));
            oos_rpg.writeObject(bestiaryForm);
            oos_rpg.close();
            System.out.println("Saving form of " + rpg.getName() + " done");
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }

    /**
     * Save the form as a Template who can be used to create a new form
     */
    public static void saveBestiaryFormAsTemplate(BestiaryForm bestiaryForm, RPGInfo rpg) {
        try {
            ObjectOutputStream oos_rpg = new ObjectOutputStream(new FileOutputStream(
                    StartApp.FOLDER + StartApp.FOLDER_TEMPLATE + StartApp.BESTIARY_FILE + "_"
                            + StartApp.BESTIARY_TEMPLATE_FILE + "_" + rpg.getName() + StartApp.EXTENSION));
            oos_rpg.writeObject(bestiaryForm);
            oos_rpg.close();
            System.out.println("Saving template of " + rpg.getName() + " done");
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }
}
