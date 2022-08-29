package model.rpg;

import java.io.Serializable;
import java.util.ArrayList;

import model.bestiary.BestiaryForm;
import model.bestiary.BestiaryInfo;
import model.bestiary.LoadBestiary;

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
    private RPGControler rpgControler;
    private BestiaryInfo bestiary;
    private ArrayList<BestiaryForm> bestiaryFormTemplates;

    public RPGInfo(RPGControler rpgControler, String name) {
        this.name = name;
        this.id = idRPG;
        this.rpgControler = rpgControler;
        this.bestiary = new BestiaryInfo(this);
        this.bestiaryFormTemplates = LoadBestiary.loadBestiaryTemplate(new ArrayList<BestiaryForm>(),
                this.rpgControler);
        idRPG++;
        System.out.println("RPG n°" + id + " => " + name + " created");
    }

    public String getName() {
        return name;
    }

    public BestiaryInfo getBestiary() {
        return bestiary;
    }

    @Override
    public String toString() {
        return "RPG n°" + id + " => " + name;
    }

    public void checkIfEverythingIsLoaded(RPGControler rpgControler) {
        if (bestiary == null)
            bestiary = new BestiaryInfo(this);
        if (rpgControler != null)
            this.rpgControler = rpgControler;
        if (bestiaryFormTemplates == null)
            bestiaryFormTemplates = LoadBestiary.loadBestiaryTemplate(new ArrayList<BestiaryForm>(), rpgControler);
    }

    /**
     * Getter of all the saved templates
     */
    public ArrayList<BestiaryForm> getTemplates() {
        return bestiaryFormTemplates;
    }
}
