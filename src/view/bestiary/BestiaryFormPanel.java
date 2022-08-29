package view.bestiary;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import listener.bestiary.AddField;
import model.bestiary.BestiaryForm;

public class BestiaryFormPanel extends JPanel {

    private String ADD_BUTTON_TEXT = "Add your entity to the bestiary";
    private String EDIT_BUTTON_TEXT = "Confirm your changes";
    private JButton addOrEditButton;
    private HashMap<String, JTextField> bestiaryFormHashMap;
    private BestiaryForm bestiaryForm;

    public BestiaryFormPanel(BestiaryForm bestiaryForm) {
        this.bestiaryForm = bestiaryForm;
        this.bestiaryFormHashMap = bestiaryForm.getFields();
        this.addOrEditButton = new JButton(ADD_BUTTON_TEXT);

        this.setLayout(new BorderLayout());
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return this;
    }

    public void refresh() {
        this.removeAll();
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void changeFormToEdit() {
        this.addOrEditButton.setText(EDIT_BUTTON_TEXT);
        this.refresh();
    }

    public void changeFormToAdd() {
        this.addOrEditButton.setText(ADD_BUTTON_TEXT);
        this.refresh();
    }

    public boolean checkDisponibility(String text) {
        return !bestiaryFormHashMap.containsKey(text);
    }

    // Center panel for adding or editing fields in the bestiary
    private JScrollPane scrollPanel() {
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new GridBagLayout());
        JScrollPane scrollForm = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        int nbFields = 0;
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);


        for (String key : bestiaryFormHashMap.keySet()) {
            gbc.gridx = 0;
            gbc.gridy = nbFields;
            gbc.anchor = GridBagConstraints.LINE_END;
            scrollPanel.add(new JLabel(key), gbc);
            gbc.gridx = 1;
            gbc.gridy = nbFields;
            gbc.anchor = GridBagConstraints.CENTER;
            scrollPanel.add(bestiaryFormHashMap.get(key), gbc);
            gbc.gridx = 2;
            gbc.gridy = nbFields;
            gbc.anchor = GridBagConstraints.LINE_START;
            scrollPanel.add(new JButton("Delete field"), gbc);
            nbFields++;
        }
        return scrollForm;
    }

    // Northen information panel
    private JPanel infoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("Form to add entity"), BorderLayout.CENTER);
        infoPanel.add(addOrEditButton, BorderLayout.WEST);
        JButton cancelButton = new JButton(" Cancel");
        infoPanel.add(cancelButton, BorderLayout.EAST);
        return infoPanel;
    }

    // Southern panel for add field in the form
    private JPanel addFieldPanel() {
        JPanel addField = new JPanel();

        JButton validate = new JButton("Validate");
        JTextField fieldToAdd = new JTextField(BestiaryForm.SIZE_JTEXTFIELD);
        validate.addActionListener(new AddField(this, fieldToAdd, bestiaryForm));

        addField.setLayout(new GridBagLayout());
        GridBagConstraints gbl = new GridBagConstraints();
        gbl.fill = GridBagConstraints.HORIZONTAL;

        addField.add(new JLabel("Name of the new field : "));
        addField.add(fieldToAdd);
        addField.add(validate);

        return addField;
    }
}
