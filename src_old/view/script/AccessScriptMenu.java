package view.script;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import model.script.ScriptEvent;
import model.script.ScriptForm;

/**
 * View menu of all the created events
 * 
 * @author NailykSturm
 */
public class AccessScriptMenu extends JMenuItem {

    private static final long serialVersionUID = 1L;

    public AccessScriptMenu(ScriptEvent event, ScriptForm form, ScriptFormPanel mainPanel) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(event.toString()), BorderLayout.CENTER);
    }

}
