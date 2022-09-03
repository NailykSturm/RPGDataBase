package model.bestiary;

import java.io.Serializable;
import java.util.HashMap;

/**
 * This class is the class that manage entities of the bestiary.
 * 
 * @author NailykSturm
 */
public class BestiaryEntity implements Serializable {

    private static final long serialVersionUID = 22L;
    private static int cptEntity = 0;

    private int id;
    /** Characteristics of the entity */
    private HashMap<String, String> characteristics;

    /**
     * Constructor of the class.
     * @param characteristics the characteristics of the entity.
     */
    public BestiaryEntity(HashMap<String, String> characteristics) {
        this.characteristics = characteristics;
        this.id = cptEntity;
        cptEntity++;
    }

    /**
     * Edit an entity.
     * @param newCharacteristic the new characteristics.
     */
    public void editEntity(HashMap<String, String> newCharacteristics) {
        this.characteristics = newCharacteristics;
    }

    /**
     * Get characteristics of the entity.
     * @return the characteristics of the entity.
     */
    public HashMap<String, String> getCaracteristics() {
        return characteristics;
    }

    @Override
    public String toString() {
        String result = "Entity " + id + " = \n";
        for(String key : characteristics.keySet()) {
            result += "\t" + key + " : " + characteristics.get(key) + "\t | \n ";
        }
        return result;
    }
}
