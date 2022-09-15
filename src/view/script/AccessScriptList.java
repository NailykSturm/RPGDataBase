package view.script;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.script.ScriptEvent;
import model.script.ScriptForm;

/**
 * View of all the events that are linked to the new event
 * 
 * @author NailykSturm
 */
public class AccessScriptList extends JPanel {

    public AccessScriptList(ScriptEvent event, String value, ScriptForm form) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel(event.toString()), BorderLayout.CENTER);
        this.add(new JTextField(value), BorderLayout.EAST);
    }

}
