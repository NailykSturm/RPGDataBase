package model.bestiary;

import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JTextField;

public class BestiaryForm implements Serializable{

    private static final long serialVersionUID = 21L;
    public static int SIZE_JTEXTFIELD = 15;
    private HashMap<String, JTextField> fieldsMap;
    
    public BestiaryForm() {
        fieldsMap = new HashMap<String, JTextField>();
    }

    /**
     * Add a new field to the form
     * @param fieldName the name used to reference it
     */
    public void addField(String fieldName) {
        JTextField field = new JTextField(SIZE_JTEXTFIELD);
        fieldsMap.putIfAbsent(fieldName, field);
    }

    /**
     * Remove a field from the form
     * @param fieldName the name used to reference it
     */
    public void removeField(String fieldName) {
        fieldsMap.remove(fieldName);
    }

    /**
     * Edit a field from the form
     * @param oldFieldName the name of the field to edit
     * @param newFieldName the new name of the field
     */
    public void editField(String oldFieldName, String newFieldName) {
        String value = fieldsMap.get(oldFieldName).getText();
        fieldsMap.remove(oldFieldName);
        fieldsMap.putIfAbsent(newFieldName, new JTextField(SIZE_JTEXTFIELD));
        fieldsMap.get(newFieldName).setText(value);
    }

    public HashMap<String, JTextField> getFields() {
        return fieldsMap;
    }
}
