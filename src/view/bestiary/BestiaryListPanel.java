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

/**
 * View of all the entities in the bestiary
 * 
 * @author NailykSturm
 */
public class BestiaryListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/** Bestiary used */
    private BestiaryInfo bestiary;
    /** Parent bestiary main panel */
    private BestiaryMainPanel bestiaryMainPanel;

    /**
     * Constructor
     * @param bestiary bestiary used
     * @param bestiaryMainPanel bestiary main panel
     */
    public BestiaryListPanel(BestiaryInfo bestiary, BestiaryMainPanel bestiaryMainPanel) {
        this.bestiary = bestiary;
        this.bestiaryMainPanel = bestiaryMainPanel;
        this.setLayout(new BorderLayout());
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(mainPanel(), BorderLayout.CENTER);
    }

    /**
     * Getter of the List panel
     * @return the panel with the list of the entities
     */
    public JPanel getPanel() {
        return this;
    }

    /**
     * Create an information panel
     * @return the information panel created
     */
    private JPanel infoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("List of entities"), BorderLayout.NORTH);
        return infoPanel;
    }

    /**
     * Create a JScrollPane that show all the entities
     * @return the JScrollPane
     */
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
