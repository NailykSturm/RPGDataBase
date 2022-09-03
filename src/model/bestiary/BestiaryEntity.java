package model.bestiary;

import java.io.Serializable;
import java.util.HashMap;

public class BestiaryEntity implements Serializable {

    private static final long serialVersionUID = 22L;
    private static int cptEntity = 0;

    private int id;
    private HashMap<String, String> characteristics;

    public BestiaryEntity(HashMap<String, String> characteristics) {
        this.characteristics = characteristics;
        this.id = cptEntity;
        System.out.println("New entity created with id " + id);
        cptEntity++;
    }

    public void editEntity(HashMap<String, String> newCharacteristics) {
        this.characteristics = newCharacteristics;
    }

    public HashMap<String, String> getCaracteristics() {
        return characteristics;
    }

    /**
     * Function that edit one characteristic of the entity, also work if the characteristic doesn't exist
     * @param characToChange the name of the characteristic to change
     * @param oldValue the old value of the characteristic
     * @param newValue the new value of the characteristic
     */
    public void editCharacteristic(String characToChange, String oldValue, String newValue) {
        if (!characteristics.replace(characToChange, oldValue, newValue))
            characteristics.put(characToChange, newValue);
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
