package listener.bestiary;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.bestiary.BestiaryEntity;
import view.bestiary.BestiaryFormPanel;
import view.bestiary.BestiaryMainPanel;

/**
 * Listener used to ask an edit for an entity
 * 
 * @author NailykSturm
 */
public class EditEntityRequest implements MouseListener {

    private BestiaryEntity entity;
    private BestiaryMainPanel bestiaryMainPanel;

    public EditEntityRequest(BestiaryEntity entity, BestiaryMainPanel bestiaryMainPanel) {
        this.entity = entity;
        this.bestiaryMainPanel = bestiaryMainPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You are edditing the entity "+ entity);
        BestiaryFormPanel formPanel = bestiaryMainPanel.getFormPanel();
        formPanel.changeEntityToEdit(entity);
        bestiaryMainPanel.refresh();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
