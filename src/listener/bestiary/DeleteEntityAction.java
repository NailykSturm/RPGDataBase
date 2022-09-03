package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryMainPanel;

/**
 * Listener used to delete an entity
 * 
 * @author NailykSturm
 */
public class DeleteEntityAction implements ActionListener {

    private BestiaryMainPanel bestiaryMainPanel;
    private BestiaryInfo bestiary;
    private BestiaryEntity entity;

    public DeleteEntityAction(BestiaryEntity entity, BestiaryInfo bestiary, BestiaryMainPanel bestiaryMainPanel) {
        this.bestiaryMainPanel = bestiaryMainPanel;
        this.bestiary = bestiary;
        this.entity = entity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bestiary.removeEntity(entity);
        bestiaryMainPanel.refresh();
    }
}
