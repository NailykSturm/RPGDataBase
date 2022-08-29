package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryInfo;

public class BestiaryListPanel extends JPanel {

    private BestiaryInfo bestiary;

    public BestiaryListPanel(BestiaryInfo bestiary) {
        this.bestiary = bestiary;
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
        System.out.println("DEBUG => BestiaryListPanel => number of entities : " + bestiary.getEntities().size());
        for (BestiaryEntity entity : bestiary.getEntities()) {
            mainPanel.add(new BestiaryEntityPanel(entity).getPanel(), gbc);
        }
        return scrollPane;
    }
}
