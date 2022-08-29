package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.bestiary.BestiaryEntity;

public class BestiaryEntityPanel extends JPanel {

    private BestiaryEntity entity;

    public BestiaryEntityPanel(BestiaryEntity entity) {
        this.entity = entity;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        this.setLayout(new BorderLayout());
        this.add(entityPanel(), BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return this;
    }

    private JPanel entityPanel() {
        JPanel entityPanel = new JPanel();
        entityPanel.setBackground(Color.YELLOW);
        entityPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = -1;
        gbc.gridy = -1;
        for (String field : entity.getCaracteristics().keySet()) {
            entityPanel.add(new JLabel(field + " : " + entity.getCaracteristics().get(field)), gbc);
        }
        return entityPanel;
    }
}
