package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that control all the bestiary for a given RPG
 * @author NailykSturm
 */
public class BestiaryInfo implements Serializable {

    private static final long serialVersionUID = 20L;
    private static int idBestiary = 0;

    private int id;
    private ArrayList<BestiaryForm> templates;
    private ArrayList<BestiaryEntity> entities;
    private BestiaryForm form;

    /**
     * Constructor for the bestiary info
     */
    public BestiaryInfo() {
        this.id = idBestiary;
        this.entities = new ArrayList<BestiaryEntity>();
        this.form = new BestiaryForm();
        idBestiary++;
        System.out.println("New bestiary created with id " + id);
    }

    /**
     * Add a new entity to the bestiary
     */
    public void addEntity(BestiaryEntity entity) {
        this.entities.add(entity);
    }

    /**
     * Remove an entity from the bestiary
     */
    public void removeEntity(BestiaryEntity entity) {
        this.entities.remove(entity);
    }

    /**
     * Edit an entity from the bestiary
     */
    public void editEntity(BestiaryEntity entity, String fieldToChange, String newValue) {
        entity.editCaracteristic(fieldToChange, newValue);
    }

    /**
     * Method to check if any information isn't null
     * after retrieve the informations from the saved file
     */
    public void checkIfEverythingIsLoaded() {
        if (form == null)
            form = new BestiaryForm();
        if (entities == null)
            entities = new ArrayList<BestiaryEntity>();
        if (templates == null)
            templates = new ArrayList<BestiaryForm>();
    }

    /**
     * Getter of the current form for entities
     */
    public BestiaryForm getCurrentForm() {
        return form;
    }

    /**
     * Getter of all the saved templates
     */
    public ArrayList<BestiaryForm> getTemplates() {
        return templates;
    }
}
