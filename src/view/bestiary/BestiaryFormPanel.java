package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import listener.bestiary.AddBestiaryAction;
import listener.bestiary.AddFieldAction;
import listener.bestiary.DeleteFieldAction;
import listener.bestiary.EditBestiaryAction;
import listener.bestiary.EditFieldAction;
import listener.bestiary.EditFieldRequest;
import listener.bestiary.ResetBestiaryForm;
import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryFieldForm;
import model.bestiary.BestiaryForm;
import model.bestiary.BestiaryInfo;

/** 
 * Class that used to show the form for adding or editing an entity
 * 
 * @author NailykSturm
 */
public class BestiaryFormPanel extends JPanel {

    /** Mode for adding a field */
    private static final String ADD_FIELD_MODE = "Add Field";
    /** Mode for editing a field */
    private static final String EDIT_FIELD_MODE = "Edit Field";
    /** Mode of adding an entity */
    private static final String ADD_ENTITY_MODE = "Add Entity";
    /** Mode of editing an entity */
    private static final String EDIT_ENTITY_MODE = "Edit Entity";
    private HashMap<String, BestiaryFieldForm> bestiaryFormHashMap;
    private HashMap<String, JCheckBox> checkBoxes;
    /** The bestiary's main panel */
    private BestiaryMainPanel mainPanel;
    /** The form for this bestiary */
    private BestiaryForm bestiaryForm;
    /** The bestiary used */
    private BestiaryInfo bestiary;
    /** Mode for a fiel (add/edit) */
    private String field_mode = ADD_FIELD_MODE;
    /** Mode for the entity (add/edit) */
    private String entity_mode = ADD_ENTITY_MODE;
    /** The field to edit (null if the field_mode is adding) */
    private String editField = null;
    /** The editing entity (null if the entity_mode is adding) */
    private BestiaryEntity editEntity = null;

    /**
     * Constructor
     * @param mainPanel bestiary's main panel
     * @param bestiary the bestiary used 
     */
    public BestiaryFormPanel(BestiaryMainPanel mainPanel, BestiaryInfo bestiary) {
        this.bestiary = bestiary;
        this.mainPanel = mainPanel;
        this.field_mode = ADD_FIELD_MODE;
        this.entity_mode = ADD_ENTITY_MODE;
        this.bestiaryForm = bestiary.getCurrentForm();
        this.bestiaryFormHashMap = bestiaryForm.getFields();

        HashMap<String, String> fieldsOptions = bestiaryForm.getOptions();
        checkBoxes = new HashMap<String, JCheckBox>();

        for (String key : fieldsOptions.keySet()) {
            JCheckBox checkBox = new JCheckBox(fieldsOptions.get(key));
            checkBoxes.put(key, checkBox);
        }
        this.setLayout(new BorderLayout());
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return this;
    }

    /**
     * Refresh the display
     */
    public void refresh() {
        this.bestiaryForm = bestiary.getCurrentForm();
        this.bestiaryFormHashMap = bestiaryForm.getFields();
        for(JCheckBox checkBox : checkBoxes.values()) {
            checkBox.setSelected(false);
        }
        this.removeAll();
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    /**
     * Change the form's action mode to editing
     */
    public void changeFormToEdit(String fieldName) {
        this.field_mode = EDIT_FIELD_MODE;
        this.editField = fieldName;
    }

    /**
     * Change the form's action mode to adding
     */
    public void changeFormToAdd() {
        this.field_mode = ADD_FIELD_MODE;
        this.editField = null;
    }

    /**
     * Change the entity's action mode to editing
     * @param entity entity to edit
     */
    public void changeEntityToEdit(BestiaryEntity entity) {
        this.entity_mode = EDIT_ENTITY_MODE;
        this.editEntity = entity;
    }

    /**
     * Change the entity's action mode to adding
     */
    public void changeEntityToAdd() {
        this.entity_mode = ADD_ENTITY_MODE;
        this.editEntity = null;
    }

    /**
     * Getter of all the fields 
     * @return the HashMap of the fields
     */
    public HashMap<String, BestiaryFieldForm> getBestiaryFormHashMap() {
        return bestiaryFormHashMap;
    }

    /**
     * Getter of the checkbox used for options
     * @return a HashMap with the options
     */
    public HashMap<String, JCheckBox> getOptionsFiels() {
        return checkBoxes;
    }

    /**
     * Create a JScrollPanel with the form inside for creating or editing an entity
     * @return the JScrollPane of the form
     */
    private JScrollPane scrollPanel() {
        JPanel scrollPanel = new JPanel();
        JScrollPane scrollForm = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scrollPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcScrollPanel = new GridBagConstraints();
        gbcScrollPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcScrollPanel.insets = new Insets(1, 0, 1, 0);
        gbcScrollPanel.gridx = 0;
        gbcScrollPanel.gridy = GridBagConstraints.RELATIVE;

        HashMap<String, ArrayList<String>> options = bestiaryForm.getFieldsOptions();
        HashMap<String, String> entityCharacs = null;
        if (entity_mode == EDIT_ENTITY_MODE && editEntity != null)
            entityCharacs = editEntity.getCaracteristics();

        for (String key : bestiaryFormHashMap.keySet()) {
            ArrayList<String> fieldOptions = options.get(key);
            JPanel field = new JPanel();
            field.setLayout(new GridBagLayout());
            GridBagConstraints gbcField = new GridBagConstraints();
            gbcField.fill = GridBagConstraints.HORIZONTAL;
            gbcField.insets = new Insets(5, 1, 5, 1);
            gbcField.gridx = 1;
            gbcField.gridy = 1;
            gbcField.anchor = GridBagConstraints.NORTH;
            field.add(new JLabel(key), gbcField);

            gbcField.gridx = GridBagConstraints.RELATIVE;
            if (this.entity_mode == EDIT_ENTITY_MODE && editEntity != null && entityCharacs != null) {
                BestiaryFieldForm fieldComponent = bestiaryFormHashMap.get(key);
                fieldComponent.setValue(entityCharacs.get(key));
                field.add(fieldComponent.getComponent(), gbcField);
            } else {
                field.add(bestiaryFormHashMap.get(key).getComponent(), gbcField);
            }

            gbcField.gridx = GridBagConstraints.RELATIVE;
            JButton deleteButton = new JButton("Delete field");
            deleteButton.addActionListener(new DeleteFieldAction(key, bestiary, this));

            field.add(deleteButton, gbcField);
            gbcField.gridx = GridBagConstraints.RELATIVE;
            JButton editButton = new JButton("Edit field");
            editButton.addActionListener(new EditFieldRequest(key, this));
            field.add(editButton, gbcField);

            if (fieldOptions != null) {
                if (fieldOptions.contains(BestiaryForm.OPT_REQUIRED))
                    field.setBorder(BorderFactory.createDashedBorder(Color.RED, 2, 2));
            }
            if (editField != null && editField.equals(key)) {
                field.setBackground(Color.BLACK);
            }
            scrollPanel.add(field, gbcScrollPanel);
        }
        return scrollForm;
    }

    // Northen information panel
    private JPanel infoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 1, 5, 1);
        JButton resetButton = new JButton("Reset form");
        resetButton.addActionListener(new ResetBestiaryForm(bestiaryForm, this));
        if (entity_mode == ADD_ENTITY_MODE) {
            JButton addButton = new JButton("Add your entity to the bestiary");
            addButton.addActionListener(new AddBestiaryAction(mainPanel, bestiary));
            infoPanel.add(addButton, gbc);
        } else if (entity_mode == EDIT_ENTITY_MODE) {
            JButton editButton = new JButton("Edit your entity in the bestiary");
            editButton.addActionListener(new EditBestiaryAction(this, mainPanel, bestiary, bestiaryForm, editEntity));
            infoPanel.add(editButton, gbc);
        }
        infoPanel.add(new JLabel("Form to add entity"), gbc);
        infoPanel.add(resetButton, gbc);
        return infoPanel;
    }

    // Southern panel for add field in the form
    private JPanel addFieldPanel() {
        JPanel addField = new JPanel();

        JButton validate = new JButton("Validate");
        JTextField fieldToAdd = new JTextField(BestiaryForm.SIZE_JTEXTFIELD);

        if (field_mode == EDIT_FIELD_MODE) {
            fieldToAdd.setText(editField);
            fieldToAdd.setEditable(false);
            validate.addActionListener(new EditFieldAction(editField, bestiaryForm, this));
        } else {
            validate.addActionListener(new AddFieldAction(this, fieldToAdd, bestiaryForm));
        }

        addField.setLayout(new GridBagLayout());
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.fill = GridBagConstraints.HORIZONTAL;

        addField.add(new JLabel("Name of the new field : "));
        addField.add(fieldToAdd);
        addField.add(validate);

        gbl.gridx = 1;
        gbl.gridy = GridBagConstraints.RELATIVE;
        for (String key : checkBoxes.keySet()) {
            JCheckBox checkBox = checkBoxes.get(key);
            addField.add(checkBox, gbl);
            if (field_mode == EDIT_FIELD_MODE) {
                ArrayList<String> options = bestiary.getCurrentForm().getFieldsOptions().get(editField);
                if (options != null && options.contains(key))
                    checkBox.setSelected(true);
            }
        }

        return addField;
    }
}
