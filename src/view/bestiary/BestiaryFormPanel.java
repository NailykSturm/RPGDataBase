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
import listener.bestiary.AddField;
import listener.bestiary.DeleteFieldRequest;
import listener.bestiary.EditFielAction;
import listener.bestiary.EditFieldRequest;
import listener.bestiary.ResetBestiaryForm;
import model.bestiary.BestiaryForm;
import model.bestiary.BestiaryInfo;

public class BestiaryFormPanel extends JPanel {

    private static final String Add_MODE = "Add";
    private static final String Edit_MODE = "Edit";
    private JButton addButton;
    private JButton editButton;
    private HashMap<String, JTextField> bestiaryFormHashMap;
    private HashMap<String, JCheckBox> checkBoxes;
    private BestiaryForm bestiaryForm;
    private BestiaryInfo bestiary;
    private String mode;
    private String editField = null;

    public BestiaryFormPanel(BestiaryMainPanel mainPanel, BestiaryInfo bestiary) {
        this.bestiary = bestiary;
        this.mode = Add_MODE;
        this.bestiaryForm = bestiary.getCurrentForm();
        this.bestiaryFormHashMap = bestiaryForm.getFields();
        addButton = new JButton("Add your entity to the bestiary");
        addButton.addActionListener(new AddBestiaryAction(mainPanel, bestiary));

        editButton = new JButton("Edit your entity in the bestiary");
        editButton.addActionListener(new AddBestiaryAction(mainPanel, bestiary));

        HashMap<String, String> fieldsOptions = bestiaryForm.getOptions();
        checkBoxes = new HashMap<String, JCheckBox>();

        for (String key : fieldsOptions.keySet()) {
            JCheckBox checkBox = new JCheckBox(fieldsOptions.get(key));
            checkBoxes.put(key, checkBox);
        }

        this.setLayout(new BorderLayout());
        this.add(infoPanel(addButton), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return this;
    }

    public void refresh() {
        this.removeAll();
        if (this.mode == Add_MODE)
            this.add(infoPanel(addButton), BorderLayout.NORTH);
        else
            this.add(infoPanel(editButton), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void changeFormToEdit(String fieldName) {
        this.mode = Edit_MODE;
        this.editField = fieldName;
    }

    public void changeFormToAdd() {
        this.mode = Add_MODE;
        this.editField = null;
    }

    public HashMap<String, JTextField> getBestiaryFormHashMap() {
        return bestiaryFormHashMap;
    }

    // Center panel for adding or editing fields in the bestiary
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
            field.add(bestiaryFormHashMap.get(key), gbcField);
            gbcField.gridx = GridBagConstraints.RELATIVE;
            JButton deleteButton = new JButton("Delete field");
            deleteButton.addActionListener(new DeleteFieldRequest(key, bestiary, this));

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
    private JPanel infoPanel(JButton addOrEditButton) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 1, 5, 1);
        JButton resetButton = new JButton("Reset form");
        resetButton.addActionListener(new ResetBestiaryForm(bestiaryForm, this));
        infoPanel.add(addOrEditButton, gbc);
        infoPanel.add(new JLabel("Form to add entity"), gbc);
        infoPanel.add(resetButton, gbc);
        return infoPanel;
    }

    // Southern panel for add field in the form
    private JPanel addFieldPanel() {
        JPanel addField = new JPanel();

        JButton validate = new JButton("Validate");
        JTextField fieldToAdd = new JTextField(BestiaryForm.SIZE_JTEXTFIELD);

        if (mode == Edit_MODE) {
            fieldToAdd.setText(editField);
            fieldToAdd.setEditable(false);
            validate.addActionListener(new EditFielAction(editField, bestiaryForm, this));
        } else {
            validate.addActionListener(new AddField(this, fieldToAdd, bestiaryForm));
        }

        addField.setLayout(new GridBagLayout());
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.fill = GridBagConstraints.HORIZONTAL;

        addField.add(new JLabel("Name of the new field : "));
        addField.add(fieldToAdd);
        addField.add(validate);

        gbl.gridx = 1;
        gbl.gridy = GridBagConstraints.RELATIVE;
        for(String key : checkBoxes.keySet()) {
            JCheckBox checkBox = checkBoxes.get(key);
            addField.add(checkBox, gbl);
            if(mode == Edit_MODE){
                ArrayList<String> options = bestiary.getCurrentForm().getFieldsOptions().get(editField);
                if(options != null && options.contains(key))
                    checkBox.setSelected(true);
            }
        }

        return addField;
    }

    public HashMap<String, JCheckBox> getOptionsFiels() {
        return checkBoxes;
    }
}
