package view.script;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.bestiary.BestiaryEntity;
import model.script.ScriptForm;

public class EntityScriptList extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     * @param form
     * @param entity
     */
    public EntityScriptList(BestiaryEntity entity, ScriptForm form) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        this.setLayout(new GridBagLayout());
        this.setBackground(Color.GRAY);
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
