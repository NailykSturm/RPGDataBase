package controller.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.bestiary.BestiaryFormPanel;

/**
 * Listener used to ask an edit for a field
 * 
 * @author NailykSturm
 */
public class EditFieldRequest implements ActionListener {

    private BestiaryFormPanel bestiaryFormPanel;
    private String fieldName;

    public EditFieldRequest(String key, BestiaryFormPanel bestiaryFormPanel) {
        this.fieldName = key;
        this.bestiaryFormPanel = bestiaryFormPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bestiaryFormPanel.changeFormToEdit(fieldName);
        bestiaryFormPanel.refresh();
    }

}
