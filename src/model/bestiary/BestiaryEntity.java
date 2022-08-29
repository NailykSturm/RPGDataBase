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
    
    public HashMap<String, String> getCaracteristics() {
        return characteristics;
    }

    public void editCaracteristic(String fieldToChange, String newValue) {
        characteristics.replace(fieldToChange, newValue);
    }
}
