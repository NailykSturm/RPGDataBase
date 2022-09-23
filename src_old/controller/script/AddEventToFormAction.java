package controller.script;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import model.script.ScriptEvent;
import model.script.ScriptForm;
import view.script.AccessScriptMenu;
import view.script.ScriptFormPanel;

/**
 * Listener for adding a parent event to the new event
 */
public class AddEventToFormAction implements ActionListener {

    private ScriptEvent event;
    private ScriptForm form;
    private ScriptFormPanel scriptFormPanel;
    private JMenu menu;
    private AccessScriptMenu accessScriptMenu;

    public AddEventToFormAction(ScriptEvent event, ScriptForm form, ScriptFormPanel scriptFormPanel, JMenu accessMenu, AccessScriptMenu accessScriptMenu) {
        this.event = event;
        this.form = form;
        this.scriptFormPanel = scriptFormPanel;
        this.menu = accessMenu;
        this.accessScriptMenu = accessScriptMenu;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("DEBUG => AddEventToFormAction => actionPerformed => event : " + event
                + " added as a parent of the event");
        form.addEvent(event, "TODO : add a description");
        menu.remove(accessScriptMenu);
        scriptFormPanel.getMainPanel().refresh();
    }

}
