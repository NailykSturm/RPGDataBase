package model.bestiary;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * This class is the class that manage the fields of the bestiary form.
 * 
 * @author NailykSturm
 */
public class BestiaryFieldForm implements Serializable {

    public final static long serialVersionUID = 23L;

    public static final String JTextField = "JTextField";
    public static final String JCheckBox = "JCheckBox";
    public static final String JSpinner = "JSpinner";
    public static final String JSlider = "JSlider";

    /** The name of the field */
    private String name;
    /** List of options for the field */
    private ArrayList<String> options;
    /** Component used for the field */
    private String choosenComposant = JTextField;
    private JTextField textField = null;
    private JCheckBox checkBox = null;
    private JSpinner spinner = null;
    private JSlider slider = null;

    /**
     * Constructor of the class.
     * 
     * @param name of the field
     */
    public BestiaryFieldForm(String name) {
        this.name = name;
        options = new ArrayList<String>();
        setPreferedComponent();
    }

    /**
     * Constructor of the class.
     * 
     * @param name    of the field
     * @param options of the field
     */
    public BestiaryFieldForm(String name, ArrayList<String> options) {
        this.name = name;
        this.options = options;
        setPreferedComponent();
    }

    /**
     * Replace the current options by the new ones
     * 
     * @param options to replace by
     */
    public void editOptions(ArrayList<String> options) {
        this.options = options;
        setPreferedComponent();
    }

    /**
     * 
     * @return the list of options for this field
     */
    public ArrayList<String> getOptions() {
        return options;
    }

    /**
     * 
     * @return the name of the field
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the value of the field
     */
    public String getValue() {
        if (textField != null)
            return textField.getText();
        if (checkBox != null)
            return String.valueOf(checkBox.isSelected());
        if (spinner != null)
            return spinner.getValue().toString();
        if (slider != null)
            return String.valueOf(slider.getValue());

        return "ERROR => No value found";
    }

    /**
     * 
     * @return the component used for this field
     */
    public JPanel getComponent() {
        // TODO : Return the component as JPanel (view.bestiary.BestiaryFieldComponent)
        JPanel panel = new JPanel();
        if (textField != null)
            panel.add(textField);
        if (checkBox != null)
            panel.add(checkBox);
        if (spinner != null)
            panel.add(spinner);
        if (slider != null)
            panel.add(slider);

        return panel;
    }

    /**
     * Function that set a value for the component
     * 
     * @param value to set
     */
    public void setValue(String string) {
        if (textField != null)
            textField.setText(string);
        else if (checkBox != null)
            checkBox.setSelected(Boolean.parseBoolean(string));
        else if (spinner != null)
            spinner.setValue(Integer.parseInt(string));
        else if (slider != null)
            slider.setValue(Integer.parseInt(string));
    }

    /**
     * Allow to set a new composant to change the field
     * 
     * @param component to set
     */
    public void changeComponent(String component) {
        this.choosenComposant = component;
        setPreferedComponent();
    }

    /**
     * Reset the component used for this field
     */
    public void reset() {
        if (textField != null)
            textField.setText("");
        if (checkBox != null)
            checkBox.setSelected(false);
        if (spinner != null)
            spinner.setValue(0);
        if (slider != null)
            slider.setValue(0);
    }

    /**
     * Function that check if the field is correctly initialized
     */
    public void checkIfEverythingIsLoaded() {
        System.out.println("Check if everything is loaded for the field " + name);
        if (options == null) {
            options = new ArrayList<String>();
            System.out.println("BestiaryFieldForm: options was null");
        }
    }

    /**
     * Set the prefered component for this field
     */
    private void setPreferedComponent() {
        if (options.contains(BestiaryForm.OPT_CHECKBOX))
            choosenComposant = JCheckBox;
        else if (options.contains(BestiaryForm.OPT_COUNTER))
            choosenComposant = JSpinner;
        else
            choosenComposant = JTextField;

        switch (choosenComposant) {
            case JCheckBox:
                this.checkBox = new JCheckBox();
                break;
            case JSpinner:
                this.spinner = new JSpinner();
                break;
            case JSlider:
                this.slider = new JSlider();
                break;
            default:
                this.textField = new JTextField(BestiaryForm.SIZE_JTEXTFIELD);
                break;
        }
    }
}