package model.rpg;

import java.io.Serializable;

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

    public RPGInfo(String name) {
        this.name = name;
        this.id = idRPG;
        idRPG++;
        System.out.println("RPG n°" + id + " => " + name + " created");
    }

    public String getName() {
        return name;
    }

    public String getStringForSave(){
        return id + "_" + name + "_";
    }

    @Override
    public String toString() {
        return "RPG n°" + id + " => " + name;
    }
}
