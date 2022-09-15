package view.script;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.script.ValidateCreationEvent;
import controller.script.ValidateEditionEvent;
import model.main.StartApp;
import model.rpg.RPGInfo;
import model.script.ScriptForm;

/**
 * View of the bar at the bottom of the script editor.
 * 
 * @author NailykSturm
 */
public class ScriptFormPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Strings to control the mode of event creation (Adding a new one, or editting
     * an existant)
     */
    private static final String ADD = "CREATE";
    private static final String EDIT = "EDIT";
    private String MODE = ADD;

    /** The rpg linked to the script */
    private RPGInfo rpg;
    /** The main panel of Script */
    private ScriptMainPanel mainPanel;
    /** The form used */
    private ScriptForm form;

    /**
     * Constructor
     * 
     * @param rpg the rpg used for this script
     */
    public ScriptFormPanel(RPGInfo rpg, ScriptMainPanel scriptMainPanel) {
        this.rpg = rpg;
        this.mainPanel = scriptMainPanel;
        this.form = rpg.getScript().getForm();
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(69, 206, 35));
        this.setMaximumSize(new Dimension((int) StartApp.screenSize.getWidth(), 200));
        formPanel();
    }

    /**
     * Method to change the mode of the form to EDIT
     */
    public void changeToEdit() {
        this.MODE = EDIT;
    }

    /**
     * Method to change the mode of the form to ADD
     */
    public void changeToAdd() {
        this.MODE = ADD;
    }

    /**
     * Method to refresh data in the panel
     */
    public void refresh() {
        this.form = rpg.getScript().getForm();
        this.removeAll();
        formPanel();
        this.repaint();
        this.revalidate();
    }

    /**
     * @return the main panel for the script
     */
    public ScriptMainPanel getMainPanel() {
        return this.mainPanel;
    }

    /**
     * Method to create the panel
     */
    private void formPanel() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        // Label for helping user to know what to do
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 2;
        c.weighty = 1;
        this.add(new JLabel("Description for a new evenement in your RPG"), c);

        // TextArea for the description
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 2;
        c.weighty = 3;
        this.add(form.getTextArea(), c);

        // Menu bar with all the entity created in the bestiary
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        JMenu entityMenu = new JMenu("Add an ennemy ?");
        JMenuBar entityMenuBar = new JMenuBar();
        rpg.getBestiary().getEntities().forEach(entity -> {
            if (!form.getAllLinkedEntities().contains(entity))
                entityMenu.add(new EntityScriptMenu(entity, form, this));
        });
        entityMenuBar.add(entityMenu);
        this.add(entityMenuBar, c);

        // List of all entity selected
        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        JScrollPane entityListScroll = ennemySelectedPanel();
        this.add(entityListScroll, c);

        // Menu with all the previous event created
        c.gridx = 3;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        JMenu accessMenu = new JMenu("Accessible from what event ?");
        JMenuBar acessMenuBar = new JMenuBar();
        acessMenuBar.add(accessMenu);
        rpg.getScript().getEvents().forEach(event -> {
            if (!form.getAllLinkedEvents().containsKey(event))
                accessMenu.add(new AccessScriptMenu(event, form, this));
        });
        this.add(acessMenuBar, c);

        // List of all event selected
        c.gridx = 3;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        JScrollPane eventList = eventSelectedPanel();
        this.add(eventList, c);

        // Button to validate the creation or the edition of an event
        c.gridx = 4;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 1;
        if (MODE == ADD) {
            JButton validateButton = new JButton("Validate creation");
            validateButton.addActionListener(new ValidateCreationEvent(rpg, this, form));
            this.add(validateButton, c);
        } else if (MODE == EDIT) {
            JButton validateButton = new JButton("Validate edition");
            validateButton.addActionListener(new ValidateEditionEvent(rpg, this, form));
            this.add(validateButton, c);
        }
    }

    /**
     * Method to create the panel with all the entity selected
     * 
     * @return the panel created
     */
    private JScrollPane ennemySelectedPanel() {
        JPanel entityList = new JPanel();
        JScrollPane entityListScroll = new JScrollPane(entityList);
        entityListScroll.setMaximumSize(new Dimension(200, 200));
        entityList.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        form.getAllLinkedEntities().forEach(entity -> {
            entityList.add(new EntityScriptList(entity, form), gbc);
            gbc.gridy++;
        });
        return entityListScroll;
    }

    /**
     * Method to create the panel with all the event selected
     * 
     * @return the panel created
     */
    private JScrollPane eventSelectedPanel() {
        JPanel eventList = new JPanel();
        JScrollPane eventListScroll = new JScrollPane(eventList);
        eventListScroll.setMaximumSize(new Dimension(200, 200));
        form.getAllLinkedEvents().forEach((event, value) -> {
            eventList.add(new AccessScriptList(event, value, form));
        });
        return eventListScroll;
    }
}
