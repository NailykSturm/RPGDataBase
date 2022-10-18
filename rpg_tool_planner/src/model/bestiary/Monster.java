package model.bestiary;

import java.util.HashMap;

public class Monster {
    
    HashMap<String, String> caracs = new HashMap<>();
    HashMap<String, FieldOptions[]> options = new HashMap<>();

    public Monster(){}

    public void addCarac(String name, String value){
        caracs.put(name, value);
    }

    public void addCarac(String name, int value){
        caracs.put(name, Integer.toString(value));
    }

    public void addCarac(String name, boolean value){
        caracs.put(name, Boolean.toString(value));
    }

    public void removeCarac(String name){
        caracs.remove(name);
    }

    public void editCarac(String name, String value){
        caracs.replace(name, value);
    }

    public void editCarac(String name, int value){
        caracs.replace(name, Integer.toString(value));
    }

    public void editCarac(String name, boolean value){
        caracs.replace(name, Boolean.toString(value));
    }
}
