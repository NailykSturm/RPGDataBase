package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;

import model.rpg.RPGInfo;

/**
 * This class is the class that manage the bestiary form.
 * 
 * @author NailykSturm
 */
public class BestiaryForm implements Serializable {

    private final static long serialVersionUID = 21L;
    /** Initial size for JTextFields */
    public final static int SIZE_JTEXTFIELD = 15;
    /* List of options for fields */
    /** The field is required to create entity */
    public final static String OPT_REQUIRED = "REQUIRED";
    /** The field is editable */
    public final static String OPT_EDITABLE = "EDITABLE";
    /** The field is a counter */
    public final static String OPT_COUNTER = "COUNTER";
    /** Tje field is a check box */
    public final static String OPT_CHECKBOX = "CHECKBOX";
    /** The field have a time to be reloaded */
    public final static String OPT_TIME_TO_RELOAD = "TIME TO RELOAD";
    /** The field is unique */
    public final static String OPT_UNIQUE = "UNIQUE";

    /** RPG  */
    private RPGInfo rpg;
    /** HashMap of all the fields with name as key */
    private HashMap<String, JTextField> fieldsMap;
    /** HashMap of all options of all fields with their name as key */
    private HashMap<String, ArrayList<String>> fieldsOptions;

    /**
     * Constructor of the class.
     * @param rpg the model used for this form.
     */
    public BestiaryForm(RPGInfo rpg) {
        this.rpg = rpg;
        fieldsMap = new HashMap<String, JTextField>();
        fieldsOptions = new HashMap<String, ArrayList<String>>();
    }

    /**
     * Add a new field to the form
     * 
     * @param fieldName the name used to reference it
     */
    public void addField(String fieldName, ArrayList<String> options) {
        JTextField field = new JTextField(SIZE_JTEXTFIELD);
        fieldsMap.putIfAbsent(fieldName, field);
        fieldsOptions.putIfAbsent(fieldName, options);
        SaveBestiary.saveBestiaryFormToFile(this, rpg);
    }

    /**
     * Remove a field from the form
     * 
     * @param fieldName the name used to reference it
     */
    public void removeField(String fieldName) {
        fieldsMap.remove(fieldName);
        SaveBestiary.saveBestiaryFormToFile(this, rpg);
    }

    /**
     * Edit a field from the form
     * 
     * @param fieldName the name of the field to edit
     * @param options   the option of the field
     */
    public void editField(String fieldName, ArrayList<String> options) {
        if (fieldsOptions.get(fieldName) == null)
            fieldsOptions.put(fieldName, options);
        else
            fieldsOptions.replace(fieldName, options);
        SaveBestiary.saveBestiaryFormToFile(this, rpg);
    }

    /**
     * Get the HashMap of all the options for the fields
     * 
     * @return the HashMap of all the options
     */
    public HashMap<String, String> getOptions() {
        HashMap<String, String> options = new HashMap<String, String>();

        options.put(OPT_REQUIRED, "Field is required ?");
        options.put(OPT_EDITABLE, "Field is editable ?");
        options.put(OPT_COUNTER, "Field is a counter ? (means editable)");
        options.put(OPT_CHECKBOX, "Is a checkbox ?");
        options.put(OPT_TIME_TO_RELOAD, "Have a time to reload ?");
        options.put(OPT_UNIQUE, "Is unique ?");

        return options;
    }

    /**
     * Reset all the fields of the form
     */
    public void resetAllFields() {
        for (String key : fieldsMap.keySet()) {
            fieldsMap.get(key).setText("");
        }
        SaveBestiary.saveBestiaryFormToFile(this, rpg);
    }

    /**
     * Get all fields of the form
     * @return HashMap of fields with JTextFields and name as key
     */
    public HashMap<String, JTextField> getFields() {
        return fieldsMap;
    }

    /**
     * Get the options of all fields of the form
     * @return HashMap of fields with options and name as key
     */
    public HashMap<String, ArrayList<String>> getFieldsOptions() {
        return fieldsOptions;
    }

    /**
     * Check if every global variable hase been initialized
     * @param rpg the model used for this form.
     */
    public void checkIfEverythingIsLoaded(RPGInfo rpg) {
        if (fieldsMap == null)
            fieldsMap = new HashMap<String, JTextField>();
        if (fieldsOptions == null)
            fieldsOptions = new HashMap<String, ArrayList<String>>();
        if (rpg == null)
            this.rpg = rpg;
    }
}
