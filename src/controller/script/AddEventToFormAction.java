package controller.script;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.script.ScriptEvent;
import model.script.ScriptForm;
import view.script.ScriptFormPanel;

/**
 * Listener for adding a parent event to the new event
 */
public class AddEventToFormAction implements MouseListener {

    private ScriptEvent event;
    private ScriptForm form;
    private ScriptFormPanel scriptFormPanel;

    public AddEventToFormAction(ScriptEvent event, ScriptForm form, ScriptFormPanel scriptFormPanel) {
        this.event = event;
        this.form = form;
        this.scriptFormPanel = scriptFormPanel;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        System.out.println("DEBUG => AddEventToFormAction => mouseClicked => event : " + event
                + " added as a parent of the event");
        form.addEvent(event, "TODO : add a description");
        scriptFormPanel.getMainPanel().refresh();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

}
