package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;

import model.rpg.RPGInfo;

public class BestiaryForm implements Serializable {

    private final static long serialVersionUID = 21L;
    public final static int SIZE_JTEXTFIELD = 15;
    public final static String OPT_REQUIRED = "REQUIRED";
    public final static String OPT_EDITABLE = "EDITABLE";
    public final static String OPT_COUNTER = "COUNTER";
    public final static String OPT_CHECKBOX = "CHECKBOX";
    public final static String OPT_TIME_TO_RELOAD = "TIME TO RELOAD";
    public final static String OPT_UNIQUE = "UNIQUE";
    public final static String OPT_PNJ = "PNJ";
    public final static String OPT_PJ = "PJ";

    /** RPG  */
    private RPGInfo rpg;
    /** HashMap of all the fields with name as key */
    private HashMap<String, JTextField> fieldsMap;
    /** HashMap of all options of all fields with their name as key */
    private HashMap<String, ArrayList<String>> fieldsOptions;

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

    public HashMap<String, String> getOptions() {
        HashMap<String, String> options = new HashMap<String, String>();

        options.put(OPT_REQUIRED, "Field is required ?");
        options.put(OPT_EDITABLE, "Field is editable ?");
        options.put(OPT_COUNTER, "Field is a counter ? (means editable)");
        options.put(OPT_CHECKBOX, "Is a checkbox ?");
        options.put(OPT_TIME_TO_RELOAD, "Have a time to reload ?");
        options.put(OPT_UNIQUE, "Is unique ?");
        //options.put(OPT_PNJ, "Is a PNJ ?");
        //options.put(OPT_PJ, "Is a PJ ?");

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

    public void checkIfEverythingIsLoaded(RPGInfo rpg) {
        if (fieldsMap == null)
            fieldsMap = new HashMap<String, JTextField>();
        if (fieldsOptions == null)
            fieldsOptions = new HashMap<String, ArrayList<String>>();
        if (rpg == null)
            this.rpg = rpg;
    }
}
