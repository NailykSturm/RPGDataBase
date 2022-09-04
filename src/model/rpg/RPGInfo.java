package model.rpg;

import java.io.Serializable;
import java.util.ArrayList;

import model.bestiary.BestiaryForm;
import model.bestiary.BestiaryInfo;
import model.bestiary.LoadBestiary;

/**
 * RPGInfo class
 * contains all the information about the RPG
 * Link to the Bestiary, Script and Notebloc
 * 
 * @author NailykSturm
 */
public class RPGInfo implements Serializable {

    private static final long serialVersionUID = 11L;

    /** Name of the RPG */
    private String name;
    /** The controller used by this RPG */
    private RPGControler rpgControler;
    /** The bestiary of the RPG */
    private BestiaryInfo bestiary;
    /** The list of templates for the bestiary's form */
    private ArrayList<BestiaryForm> bestiaryFormTemplates;

    /**
     * Constructor of the class
     * @param rpgControler the controller used by this RPG
     * @param name the name of the RPG
     */
    public RPGInfo(RPGControler rpgControler, String name) {
        this.name = name;
        this.rpgControler = rpgControler;
        this.bestiary = new BestiaryInfo(this);
        this.bestiaryFormTemplates = LoadBestiary.loadBestiaryTemplate(this.rpgControler);
    }

    /**
     * Get the name of the RPG
     * @return the name of the RPG
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the bestiary
     * @return the bestiary linked to the RPG
     */
    public BestiaryInfo getBestiary() {
        return bestiary;
    }

    @Override
    public String toString() {
        return "RPG => " + name;
    }

    /**
     * Function that check if every globals variables are initialized
     * @param rpgControler the controller used by this RPG
     */
    public void checkIfEverythingIsLoaded(RPGControler rpgControler) {
        bestiary = new BestiaryInfo(this);
        if (rpgControler != null)
            this.rpgControler = rpgControler;
        if (bestiaryFormTemplates == null)
            bestiaryFormTemplates = LoadBestiary.loadBestiaryTemplate(rpgControler);
    }

    /**
     * Getter of all the saved templates
     * @return the list of all the saved templates
     */
    public ArrayList<BestiaryForm> getTemplates() {
        return bestiaryFormTemplates;
    }
}
