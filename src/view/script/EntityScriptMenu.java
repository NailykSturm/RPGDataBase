package view.script;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import model.bestiary.BestiaryEntity;
import model.script.ScriptForm;

/**
 * Panel of one entity for the menu of the script editor for adding an ennemy to the evenement.
 * 
 * @author NailykSturm
 */
public class EntityScriptMenu extends JMenuItem {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param entity the entity to display
     * @param form the form used
     */
    public EntityScriptMenu(BestiaryEntity entity, ScriptForm form, ScriptFormPanel scriptFormPanel) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setPreferredSize(this.getPreferredSize());
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.YELLOW);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = -1;
        gbc.gridy = -1;
        for (String field : entity.getCaracteristics().keySet()) {
            this.add(new JLabel(field + " : " + entity.getCaracteristics().get(field)), gbc);
        }
    }
}
