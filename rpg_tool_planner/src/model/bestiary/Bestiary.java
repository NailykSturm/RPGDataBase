package model.bestiary;

import java.util.ArrayList;

public class Bestiary {
    ArrayList<Field> fields = new ArrayList<Field>();

    public Bestiary(){

    }

    public void addField(Field field){
        fields.add(field);
    }

    public void removeField(Field field){
        fields.remove(field);
    }

    public ArrayList<Field> getFields(){
        return fields;
    }
}
