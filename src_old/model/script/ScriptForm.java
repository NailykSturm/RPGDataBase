package model.script;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

import model.bestiary.BestiaryEntity;

/**
 * Class used to create a script event
 * 
 * @author NailykSturm
 */
public class ScriptForm implements Serializable {

    private static final long serialVersionUID = 32L;

    private JTextArea desc;
    private ArrayList<BestiaryEntity> entities;
    private HashMap<ScriptEvent, String> events;

    public ScriptForm() {
        desc = new JTextArea(10, 100);
        entities = new ArrayList<>();
        events = new HashMap<>();
    }

    /**
     * @return the desc of the event
     */
    public JTextArea getTextArea() {
        return desc;
    }

    /**
     * @return the entities that will be linked to the event
     */
    public ArrayList<BestiaryEntity> getAllLinkedEntities() {
        return entities;
    }

    /**
     * @return the events that will be linked to the event
     */
    public HashMap<ScriptEvent, String> getAllLinkedEvents() {
        return events;
    }

    /**
     * Method to change the description of the event
     * 
     * @param desc the new description
     */
    public void changeDescription(String desc) {
        this.desc.setText(desc);
    }

    /**
     * Method to add an entity to the event
     * 
     * @param entity to add
     */
    public void addEntity(BestiaryEntity entity) {
        entities.add(entity);
    }

    /**
     * Method to remove an entity from the event
     * 
     * @param entity to remove
     */
    public void removeEntity(BestiaryEntity entity) {
        entities.remove(entity);
    }

    /**
     * Method to add an event to the event
     * 
     * @param event to add
     */
    public void addEvent(ScriptEvent event, String desc) {
        events.putIfAbsent(event, desc);
    }

    /**
     * Method to remove an event from the event
     * 
     * @param event to remove
     */
    public void removeEvent(ScriptEvent event) {
        events.remove(event);
    }

    /**
     * Method to reset all the fields of the form
     */
    public void resetAll() {
        desc.setText("");
        entities = new ArrayList<>();
        events = new HashMap<>();
    }
}
