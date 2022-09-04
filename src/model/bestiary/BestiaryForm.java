package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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

    /** RPG */
    private RPGInfo rpg;
    /** List of fields */
    private ArrayList<BestiaryFieldForm> fields;

    /**
     * Constructor of the class.
     * @param rpg the model used for this form.
     */
    public BestiaryForm(RPGInfo rpg) {
        System.out.println("DEBUG => BestiaryForm.Constructor => On créer une nouvelle instance de BestiaryForm");
        this.rpg = rpg;
        fields = LoadBestiary.loadBestiaryFormFromFile(rpg);
    }

    /**
     * Add a new field to the form
     * 
     * @param fieldName the name used to reference it
     */
    public void addField(String fieldName, ArrayList<String> options) {
        BestiaryFieldForm field = new BestiaryFieldForm(fieldName, options);
        fields.add(field);
        SaveBestiary.saveBestiaryFormToFile(fields, rpg);
    }

    /**
     * Remove a field from the form
     * 
     * @param fieldName the name used to reference it
     */
    public void removeField(String fieldName) {
        BestiaryFieldForm field = null;
        for (BestiaryFieldForm f : fields) {
            if (f.getName().equals(fieldName)) {
                field = f;
                break;
            }
        }
        if (field != null)
            fields.remove(field);
        SaveBestiary.saveBestiaryFormToFile(fields, rpg);
    }

    /**
     * Edit a field from the form
     * 
     * @param fieldName the name of the field to edit
     * @param options   the option of the field
     */
    public void editField(String fieldName, ArrayList<String> options) {
        BestiaryFieldForm field = null;
        for (BestiaryFieldForm f : fields) {
            if (f.getName().equals(fieldName)) {
                field = f;
                break;
            }
        }
        if (field != null) {
            field.editOptions(options);
        }
        SaveBestiary.saveBestiaryFormToFile(fields, rpg);
    }

    /**
     * 
     * @return the HashMap with all field options available and their description
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
        for (BestiaryFieldForm field : fields) {
            field.reset();
        }
        SaveBestiary.saveBestiaryFormToFile(fields, rpg);
    }

    /**
     * Get all fields of the form
     * 
     * @return HashMap of fields with JTextFields and name as key
     */
    public HashMap<String, BestiaryFieldForm> getFields() {
        HashMap<String, BestiaryFieldForm> fields = new HashMap<String, BestiaryFieldForm>();
        for (BestiaryFieldForm field : this.fields) {
            fields.put(field.getName(), field);
        }
        return fields;
    }

    /**
     * Get the options of all fields of the form
     * 
     * @return HashMap of fields with options and name as key
     */
    public HashMap<String, ArrayList<String>> getFieldsOptions() {
        HashMap<String, ArrayList<String>> fieldsOptions = new HashMap<String, ArrayList<String>>();
        for (BestiaryFieldForm field : this.fields) {
            fieldsOptions.put(field.getName(), field.getOptions());
        }
        return fieldsOptions;
    }

    /**
     * Check if any global variable are correctly initialized
     * @param rpg the rpg to set
     */
    public void checkIfEverythingIsLoaded(RPGInfo rpg) {
        System.out.println("DEBUG : BestiaryForm.checkIfEverythingIsLoaded => fields = " + fields);
        if (fields == null) {
            fields = LoadBestiary.loadBestiaryFormFromFile(rpg);
        }
        if (rpg == null)
            this.rpg = rpg;
    }

    public String isRealyLoaded() {
        System.out.println("DEBUG => BestiaryForm.isRealyLoaded => We try to see if anything is loaded");
        for (BestiaryFieldForm field : fields) {
            System.out.println("DEBUG => BestiaryForm.isRealyLoaded => field = " + field.getName());
        }
        return "Yes";
    }
}
