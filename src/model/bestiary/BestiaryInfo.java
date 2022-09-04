package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.rpg.RPGInfo;

/**
 * Class that control all the bestiary for a given RPG
 * 
 * @author NailykSturm
 */
public class BestiaryInfo implements Serializable {

    private static final long serialVersionUID = 20L;

    /** List of entities */
    private ArrayList<BestiaryEntity> entities;
    /** Form model */
    private BestiaryForm form;
    /** Current RPG */
    private RPGInfo rpg;

    /**
     * Constructor for the bestiary info
     * @param rpg the model used for the rpg
     */
    public BestiaryInfo(RPGInfo rpg) {
        System.out.println("DEBUG => BestiaryInfo.Constructor => Creating bestiary for " + rpg.getName());
        this.rpg = rpg;
        this.entities = LoadBestiary.loadBestiary(rpg);
        this.form = new BestiaryForm(rpg);
    }

    /**
     * Add a new entity to the bestiary
     * @param entity the entity to add
     */
    public void addEntity(BestiaryEntity entity) {
        this.entities.add(entity);
        SaveBestiary.saveBestiaryTofile(entities, rpg);
    }

    /**
     * Remove an entity from the bestiary
     * @param entity the entity to remove
     */
    public void removeEntity(BestiaryEntity entity) {
        this.entities.remove(entity);
        SaveBestiary.saveBestiaryTofile(entities, rpg);
    }

    /**
     * Edit an entity from the bestiary
     * @param entity the entity to edit
     * @param newCharacteristics the new characteristics of the entity
     */
    public void editEntity(BestiaryEntity entity, HashMap <String, String> newCharacteristics) {
        entity.editEntity(newCharacteristics);
        SaveBestiary.saveBestiaryTofile(entities, rpg);
    }

    /**
     * Function that return the bestiary
     * @return the list of entities in the bestiary
     */
    public ArrayList<BestiaryEntity> getEntities() {
        return entities;
    }

    /**
     * Function that return the form of the bestiary
     * @return the form of the bestiary
     */
    public BestiaryForm getCurrentForm() {
        return form;
    }

    public String isRealyLoaded() {
        System.out.println("DEBUG => BestiaryInfo.isRealyLoaded => Bestiary's entities : " + entities.size());
        System.out.println("DEBUG => BestiaryInfo.isRealyLoaded => Form : " + form.isRealyLoaded());
        return "Yes";
    }
}
