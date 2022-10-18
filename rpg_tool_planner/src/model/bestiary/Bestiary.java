package model.bestiary;

import java.util.ArrayList;

public class Bestiary {
    ArrayList<Field> fields = new ArrayList<Field>();
    ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Bestiary() {
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public void removeField(Field field) {
        fields.remove(field);
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void removeMonster(Monster monster) {
        monsters.remove(monster);
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void loadFromJson(Bestiary bestiary) {
        System.out.println(bestiary);
        fields = bestiary.fields;
        monsters = bestiary.monsters;
    }

    @Override
    public String toString() {
        return "Bestiary [(Fields = " + fields + ")|(monster = " + monsters + ")]";
    }
}
