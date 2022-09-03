package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;

import model.rpg.RPGInfo;

/**
 * Class that control all the bestiary for a given RPG
 * @author NailykSturm
 */
public class BestiaryInfo implements Serializable {

    private static final long serialVersionUID = 20L;
    private static int idBestiary = 0;

    private int id;
    private ArrayList<BestiaryEntity> entities;
    private BestiaryForm form;
    private RPGInfo rpg;

    /**
     * Constructor for the bestiary info
     */
    public BestiaryInfo(RPGInfo rpg) {
        this.id = idBestiary;
        this.rpg = rpg;
        this.entities = LoadBestiary.loadBestiary(rpg);
        this.form = LoadBestiary.loadBestiaryFormFromFile(rpg);
        idBestiary++;
        System.out.println("New bestiary created with id " + id);
    }

    /**
     * Add a new entity to the bestiary
     */
    public void addEntity(BestiaryEntity entity) {
        this.entities.add(entity);
        SaveBestiary.saveBestiaryTofile(entities, rpg);
    }

    /**
     * Remove an entity from the bestiary
     */
    public void removeEntity(BestiaryEntity entity) {
        this.entities.remove(entity);
        SaveBestiary.saveBestiaryTofile(entities, rpg);
    }

    /**
     * Edit an entity from the bestiary
     */
    public void editEntity(BestiaryEntity entity, String fieldToChange, String oldValue, String newValue) {
        entity.editCharacteristic(fieldToChange, oldValue, newValue);
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
}
