package controller.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JCheckBox;

import model.bestiary.BestiaryForm;
import view.bestiary.BestiaryFormPanel;

/**
 * Listener used to editing a field
 * 
 * @author NailykSturm
 */
public class EditFieldAction implements ActionListener {

    private BestiaryFormPanel bestiaryFormPanel;
    private String fieldName;
    private BestiaryForm bestiary;

    public EditFieldAction(String editField, BestiaryForm bestiaryForm,
            BestiaryFormPanel bestiaryFormPanel) {
        this.fieldName = editField;
        this.bestiaryFormPanel = bestiaryFormPanel;
        this.bestiary = bestiaryForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, JCheckBox> checkedOptions= bestiaryFormPanel.getOptionsFiels();
        ArrayList<String> options = new ArrayList<String>();

        for(String key : checkedOptions.keySet()) {
            if(checkedOptions.get(key).isSelected()) {
                options.add(key);
                System.out.println("The option " + key + " is selected");
            }
        }

        bestiary.editField(fieldName, options);
        bestiaryFormPanel.changeFormToAdd();
        bestiaryFormPanel.refresh();
    }
}
