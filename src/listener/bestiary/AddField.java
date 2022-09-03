package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import model.bestiary.BestiaryForm;
import view.bestiary.BestiaryFormPanel;

/**
 * Listener used to add a field to the list of field of the bestiary form
 * 
 * @author NailykSturm
 */
public class AddField implements ActionListener {

    private JTextField fieldToAdd;
    private BestiaryForm bestiaryForm;
    private BestiaryFormPanel bestiaryFormPanel;

    public AddField(BestiaryFormPanel bestiaryFormPanel, JTextField fieldToAdd, BestiaryForm bestiaryForm) {
        this.bestiaryFormPanel = bestiaryFormPanel;
        this.fieldToAdd = fieldToAdd;
        this.bestiaryForm = bestiaryForm;
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
        bestiaryForm.addField(fieldToAdd.getText(), options);
        fieldToAdd.setText("");
        bestiaryFormPanel.refresh();
    }
}
