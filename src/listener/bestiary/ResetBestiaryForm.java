package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bestiary.BestiaryForm;
import view.bestiary.BestiaryFormPanel;

/**
 * Listener used to reset the bestiary's form
 * 
 * @author NailykSturm
 */
public class ResetBestiaryForm implements ActionListener {

    private BestiaryForm bestiaryForm;
    private BestiaryFormPanel bestiaryFormPanel;

    public ResetBestiaryForm(BestiaryForm bestiaryForm, BestiaryFormPanel bestiaryFormPanel) {
        this.bestiaryForm = bestiaryForm;
        this.bestiaryFormPanel = bestiaryFormPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bestiaryForm.resetAllFields();
        bestiaryFormPanel.refresh();
    }

}
