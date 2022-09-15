package controller.script;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.bestiary.BestiaryEntity;
import model.script.ScriptForm;
import view.script.ScriptFormPanel;

/**
 * Listener for adding an entity to the event
 * 
 * @author NailykSturm
 */
public class AddEntityToScript implements MouseListener {

    private BestiaryEntity entity;
    private ScriptForm form;
    private ScriptFormPanel scriptFormPanel;

    public AddEntityToScript(BestiaryEntity entity, ScriptForm form, ScriptFormPanel scriptFormPanel) {
        this.entity = entity;
        this.form = form;
        this.scriptFormPanel = scriptFormPanel;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("DEBUG => AddEntityToScript => mouseClicked => entity : \n" + entity + " added to the event");
        form.addEntity(entity);
        scriptFormPanel.getMainPanel().refresh();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override 
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}

}
