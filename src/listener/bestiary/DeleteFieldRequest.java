package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryFormPanel;

public class DeleteFieldRequest implements ActionListener {

    private String key;
    private BestiaryFormPanel bestiaryFormPanel;
    private BestiaryInfo bestiary;

    public DeleteFieldRequest(String key, BestiaryInfo bestiary, BestiaryFormPanel bestiaryFormPanel) {
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
