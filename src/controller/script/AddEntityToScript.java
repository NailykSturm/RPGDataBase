package controller.script;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;

import model.bestiary.BestiaryEntity;
import model.script.ScriptForm;
import view.script.EntityScriptMenu;
import view.script.ScriptFormPanel;

/**
 * Listener for adding an entity to the event
 * 
 * @author NailykSturm
 */
public class AddEntityToScript implements ActionListener {

    private BestiaryEntity entity;
    private ScriptForm form;
    private ScriptFormPanel scriptFormPanel;
    private JMenu menu;
    private EntityScriptMenu entityScriptMenu;

    public AddEntityToScript(BestiaryEntity entity, ScriptForm form, ScriptFormPanel scriptFormPanel, JMenu entityMenu, EntityScriptMenu entityScriptMenu) {
        this.entity = entity;
        this.form = form;
        this.scriptFormPanel = scriptFormPanel;
        this.menu = entityMenu;
        this.entityScriptMenu = entityScriptMenu;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println("DEBUG => AddEntityToScript => mouseClicked => entity : \n" + entity + " added to the event");
        form.addEntity(entity);
        menu.remove(entityScriptMenu);
        scriptFormPanel.getMainPanel().refresh();
    }

}
