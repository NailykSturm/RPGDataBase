package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.bestiary.BestiaryForm;
import view.bestiary.BestiaryFormPanel;

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
        bestiaryForm.addField(fieldToAdd.getText());
        fieldToAdd.setText("");
        bestiaryFormPanel.refresh();
    }
}
