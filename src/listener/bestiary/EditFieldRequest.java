package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.bestiary.BestiaryFormPanel;

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
