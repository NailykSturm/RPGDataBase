package controller.script;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.rpg.RPGInfo;
import model.script.ScriptEvent;
import model.script.ScriptForm;
import view.script.ScriptFormPanel;

/**
 * Listener for the validation of the creation of an event.
 * 
 * @author NailykSturm
 */
public class ValidateCreationEvent implements ActionListener {

    private RPGInfo rpg;
    private ScriptFormPanel formPanel;
    private ScriptForm form;

    public ValidateCreationEvent(RPGInfo rpg, ScriptFormPanel scriptFormPanel, ScriptForm form) {
        this.rpg = rpg;
        this.formPanel = scriptFormPanel;
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (form.getTextArea().getText().length() > 0
                && (form.getAllLinkedEvents().size() > 0 || rpg.getScript().getEvents().size() == 0)) {
            ScriptEvent event = new ScriptEvent(form.getTextArea().getText(), form.getAllLinkedEvents());
            rpg.getScript().addEvent(event);
            form.resetAll();
            formPanel.getMainPanel().refresh();
            System.out.println("DEBUG => ValidateCreationEvent => actionPerformed => " + event + " created");
        } else {
            System.out.println(
                    "DEBUG => ValidateCreationEvent => actionPerformed => Error : No parent event selected OR No description");
        }
    }

}
