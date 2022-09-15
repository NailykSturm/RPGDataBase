package model.script;

import java.io.Serializable;
import java.util.ArrayList;

import model.rpg.RPGInfo;

/**
 * Controler of the script editor.
 * 
 * @author NailykSturm
 */
public class ScriptControler implements Serializable {

    private static final long serialVersionUID = 30L;

    /** List of events */
    private ArrayList<ScriptEvent> events;
    /** Form for creating an event */
    private ScriptForm form;

    public ScriptControler(RPGInfo rpgInfo) {
        this.events = new ArrayList<ScriptEvent>();
        this.form = new ScriptForm();
    }

    /**
     * @return the list of events
     */
    public ArrayList<ScriptEvent> getEvents() {
        return this.events;
    }

    /**
     * @return the form for creating an event
     */
    public ScriptForm getForm() {
        return this.form;
    }

    /**
     * Method to add an event to the list
     * 
     * @param event the event to add
     */
    public void addEvent(ScriptEvent event) {
        this.events.add(event);
    }
}
