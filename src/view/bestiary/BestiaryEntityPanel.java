package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.bestiary.EditEntityRequest;
import model.bestiary.BestiaryEntity;

/**
 * Panel of one entity
 * 
 * @author NailykSturm
 */
public class BestiaryEntityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/** The entity to display */
    private BestiaryEntity entity;
    /** The bestiary's main panel */
    private BestiaryMainPanel bestiaryMainPanel;

    /**
     * Constructor
     * @param entity the entity to display
     * @param bestiaryMainPanel the bestiary's main panel
     */
    public BestiaryEntityPanel(BestiaryEntity entity, BestiaryMainPanel bestiaryMainPanel) {
        this.entity = entity;
        this.bestiaryMainPanel = bestiaryMainPanel;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        this.setLayout(new BorderLayout());
        this.add(entityPanel(), BorderLayout.CENTER);
    }

    /**
     * 
     * @return the entity's panel
     */
    public JPanel getPanel() {
        return this;
    }

    /**
     * 
     * @return a JPanel with all the entity's data
     */
    private JPanel entityPanel() {
        JPanel entityPanel = new JPanel();
        entityPanel.addMouseListener(new EditEntityRequest(entity, bestiaryMainPanel));
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

    /**
     * Refresh displayed data
     */
    public void refresh() {
        this.removeAll();
        this.add(entityPanel(), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
