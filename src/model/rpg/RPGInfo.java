package model.rpg;

import java.io.Serializable;

import model.bestiary.BestiaryInfo;

/**
 * RPGInfo class
 * contains all the information about the RPG
 * Link to the Bestiary, the Script and the Notebloc
 */
public class RPGInfo implements Serializable {

    private static final long serialVersionUID = 11L;
    private static int idRPG = 0;

    private String name;
    private int id;
    private BestiaryInfo bestiary;

    public RPGInfo(String name) {
        this.name = name;
        this.id = idRPG;
        this.bestiary = new BestiaryInfo();
        idRPG++;
        System.out.println("RPG n°" + id + " => " + name + " created");
    }

    public String getName() {
        return name;
    }

    public String getStringForSave(){
        return id + "_" + name + "_";
    }

    public BestiaryInfo getBestiary() {
        return bestiary;
    }

    @Override
    public String toString() {
        return "RPG n°" + id + " => " + name;
    }

    public void checkIfEverythingIsLoaded() {
        if (bestiary != null) {
            bestiary.checkIfEverythingIsLoaded();
        }else {
            bestiary = new BestiaryInfo();
        }
    }
}
