package model.script;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import model.bestiary.BestiaryEntity;

/**
 * ScriptEvent is a class that represent an event in the script.
 * 
 * @author NailykSturm
 */
public class ScriptEvent implements Serializable {

    private static final long serialVersionUID = 31L;
    private static int counterScript = 0;
    private int idScript;
    /**
     * List of events that are bring to this event (key = ScriptEvent, Value = How
     * to pass from the key to this)
     */
    private HashMap<ScriptEvent, String> parentEvents;
    /** List of the events that are accessible from this event */
    private ArrayList<ScriptEvent> accessibleEvents;
    /** List of entity linked to the event (! Only from the bestiary !) */
    private ArrayList<BestiaryEntity> entities;
    /** Description of the event */
    private String description;

    /**
     * Constructor of the event
     * 
     * @param description of the event
     */
    public ScriptEvent(String description) {
        this.parentEvents = new HashMap<ScriptEvent, String>();
        this.accessibleEvents = new ArrayList<ScriptEvent>();
        this.entities = new ArrayList<BestiaryEntity>();
        this.description = description;
        this.idScript = counterScript;
        counterScript++;
    }

    /**
     * Constructor of the event
     * 
     * @param description of the event
     * @param events      that lead to this event
     */
    public ScriptEvent(String description, HashMap<ScriptEvent, String> events) {
        this.parentEvents = events;
        this.accessibleEvents = new ArrayList<ScriptEvent>();
        this.entities = new ArrayList<BestiaryEntity>();
        this.description = description;
        this.idScript = counterScript;
        counterScript++;
    }

    /**
     * Constructor of the event
     * 
     * @param description of the event to create
     * @param entities    linked to the event
     * @param events      that lead to this event
     */
    public ScriptEvent(String description, ArrayList<BestiaryEntity> entities, HashMap<ScriptEvent, String> events) {
        this.parentEvents = events;
        this.accessibleEvents = new ArrayList<ScriptEvent>();
        this.entities = entities;
        this.description = description;
        this.idScript = counterScript;
        counterScript++;
    }

    /**
     * Constructor of the event
     * 
     * @param description      of the event to create
     * @param entities         linked to the event
     * @param events           that lead to this event
     * @param accessibleEvents that are accessible from this event
     */
    public ScriptEvent(String description, ArrayList<BestiaryEntity> entities, HashMap<ScriptEvent, String> events,
            ArrayList<ScriptEvent> accessibleEvents) {
        this.parentEvents = events;
        this.accessibleEvents = accessibleEvents;
        this.entities = entities;
        this.description = description;
        this.idScript = counterScript;
        counterScript++;
    }

    /**
     * @return the list of events created in the script
     */
    public HashMap<ScriptEvent, String> getParentEvents() {
        return this.parentEvents;
    }

    /**
     * @return the list of entities linked to the event
     */
    public ArrayList<BestiaryEntity> getEntities() {
        return this.entities;
    }

    /**
     * @return the list of events that are accessible from this event
     */
    public ArrayList<ScriptEvent> getAccessibleEvents() {
        return this.accessibleEvents;
    }

    /**
     * Function that add a link from an event to this event
     * Carefull : the event give in parameter is an event that lead to this event
     * 
     * @param event     that lead to this event
     * @param howToPass is a little description of how to pass from the event to
     *                  this event
     */
    public void linkParentEvent(ScriptEvent event, String howToPass) {
        this.parentEvents.put(event, howToPass);
    }

    /**
     * Function that add a link from this event to an event
     * Carefull : the event give in parameter is an event that is accessible from
     * this event
     * 
     * @param event that is accessible from this event
     */
    public void linkChlidEvent(ScriptEvent event) {
        this.accessibleEvents.add(event);
    }

    /**
     * @return the description of the event
     */
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "ScriptEvent n° " + this.idScript;
    }
}
