package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import listener.bestiary.DeleteEntityAction;
import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryInfo;

public class BestiaryListPanel extends JPanel {

    private BestiaryInfo bestiary;
    private BestiaryMainPanel bestiaryMainPanel;

    public BestiaryListPanel(BestiaryInfo bestiary, BestiaryMainPanel bestiaryMainPanel) {
        this.bestiary = bestiary;
        this.bestiaryMainPanel = bestiaryMainPanel;
        this.setLayout(new BorderLayout());
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(mainPanel(), BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return this;
    }

    private JPanel infoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("List of entities"), BorderLayout.NORTH);
        return infoPanel;
    }

    private JScrollPane mainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.CYAN);
        JScrollPane scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = -1;
        for (BestiaryEntity entity : bestiary.getEntities()) {
            gbc.gridx = 0;
            gbc.gridy = -1;
            mainPanel.add(new BestiaryEntityPanel(entity, bestiaryMainPanel).getPanel(), gbc);
            gbc.gridx = 1;
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new DeleteEntityAction(entity, bestiary, bestiaryMainPanel));
            mainPanel.add(deleteButton, gbc);
        }
        return scrollPane;
    }
}
