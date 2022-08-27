package model.rpg;

import java.io.Serializable;

/**
 * RPGInfo class
 * contains all the information about the RPG
 * Link to the Bestiary, the Script and the Notebloc
 */
public class RPGInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int idRPG = 0;

    private String name;

    public RPGInfo(String name) {
        idRPG++;
        this.name = name;
        System.out.println("RPG n°" + idRPG + " => " + name + " created");
    }

    public String getName() {
        return name;
    }
}
