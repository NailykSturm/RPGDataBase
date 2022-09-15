package view.script;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.script.AddEventToFormAction;
import model.script.ScriptEvent;
import model.script.ScriptForm;

/**
 * View menu of all the created events
 * 
 * @author NailykSturm
 */
public class AccessScriptMenu extends JPanel{

    private static final long serialVersionUID = 1L;

    public AccessScriptMenu(ScriptEvent event, ScriptForm form, ScriptFormPanel mainPanel) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(event.toString()), BorderLayout.CENTER);
        this.addMouseListener(new AddEventToFormAction(event, form, mainPanel));
    }

}
