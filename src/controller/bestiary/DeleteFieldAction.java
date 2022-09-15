package controller.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryFormPanel;

/**
 * Listener used to delete a field from the bestiary's form
 * 
 * @author NailykSturm
 */
public class DeleteFieldAction implements ActionListener {

    private String key;
    private BestiaryFormPanel bestiaryFormPanel;
    private BestiaryInfo bestiary;

    public DeleteFieldAction(String key, BestiaryInfo bestiary, BestiaryFormPanel bestiaryFormPanel) {
        this.key = key;
        this.bestiary = bestiary;
        this.bestiaryFormPanel = bestiaryFormPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bestiary.getCurrentForm().removeField(key);
        bestiaryFormPanel.refresh();
    }

}
