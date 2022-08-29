package model.bestiary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.main.StartApp;
import model.rpg.RPGControler;
import model.rpg.RPGInfo;

public class LoadBestiary {

    /**
     * Load the bestiary
     */
    @SuppressWarnings("unchecked") 
    public static ArrayList<BestiaryEntity> loadBestiary(RPGInfo rpg) {
        ObjectInputStream ois_entity;
        ArrayList<BestiaryEntity> entities;

        try {
            ois_entity = new ObjectInputStream(new FileInputStream(
                    StartApp.FOLDER + StartApp.BESTIARY_FILE + StartApp.BESTIARY_ENTITY + "_" + rpg.getName()
                            + StartApp.EXTENSION));
            entities = (ArrayList<BestiaryEntity>) ois_entity.readObject();
            ois_entity.close();
        } catch (FileNotFoundException eFNF) {
            System.out.println(
                    "Error append when loading bestiary of " + rpg.getName() + " => File not found");
            entities = new ArrayList<BestiaryEntity>();
        } catch (IOException eIO) {
            System.out.println("Error append when loading bestiary of " + rpg.getName() + " => IOException");
            entities = new ArrayList<BestiaryEntity>();
            eIO.printStackTrace();
        } catch (ClassNotFoundException eCNFE) {
            System.out.println(
                    "Error append when loading bestiary of " + rpg.getName() + " => Class not found");
            entities = new ArrayList<BestiaryEntity>();
            eCNFE.printStackTrace();
        } catch (ClassCastException eCCE) {
            System.out.println(
                    "Error append when loading bestiary of " + rpg.getName() + " => Class cast exception");
            entities = new ArrayList<BestiaryEntity>();
            eCCE.printStackTrace();
        }
        return entities;
    }

    /**
     * Load the last form used
     */
    public static BestiaryForm loadBestiaryFormFromFile(RPGInfo rpg) {
        ObjectInputStream ois_rpg;
        BestiaryForm form;

        try {
            ois_rpg = new ObjectInputStream(new FileInputStream(
                    StartApp.FOLDER + StartApp.BESTIARY_FILE + "_" + StartApp.BESTIARY_FORM_FILE + "_" + rpg.getName()
                            + StartApp.EXTENSION));
            form = (BestiaryForm) ois_rpg.readObject();
            ois_rpg.close();
        } catch (FileNotFoundException eFNF) {
            System.out.println("Error append when loading form of " + rpg.getName() + " => File not found");
            form = new BestiaryForm(rpg);
        } catch (IOException eIO) {
            System.out.println("Error append when loading form of " + rpg.getName() + " => IOException");
            form = new BestiaryForm(rpg);
            eIO.printStackTrace();
        } catch (ClassNotFoundException eCNFE) {
            System.out.println("Error append when loading form of " + rpg.getName() + " => Class not found");
            form = new BestiaryForm(rpg);
            eCNFE.printStackTrace();
        }
        return form;
    }

    /**
     * Load all templates used to create a new form
     */
    public static ArrayList<BestiaryForm> loadBestiaryTemplate(ArrayList<BestiaryForm> form, RPGControler rpgs) {
        for (RPGInfo rpg : rpgs.getRPGList()) {
            ObjectInputStream ois_rpg;
            try {
                ois_rpg = new ObjectInputStream(new FileInputStream(
                        StartApp.FOLDER + StartApp.FOLDER_TEMPLATE + StartApp.BESTIARY_FILE + "_"
                                + StartApp.BESTIARY_TEMPLATE_FILE + "_" + rpg.getName() + StartApp.EXTENSION));
                form.add((BestiaryForm) ois_rpg.readObject());
                ois_rpg.close();
            } catch (FileNotFoundException eFNF) {
                System.out.println("Error append when loading template of " + rpg.getName() + " => File not found");
            } catch (IOException eIO) {
                System.out.println("Error append when loading template of " + rpg.getName() + " => IOException");
                eIO.printStackTrace();
            } catch (ClassNotFoundException eCNFE) {
                System.out.println("Error append when loading template of " + rpg.getName() + " => Class not found");
                eCNFE.printStackTrace();
            }
        }
        return form;
    }
}
