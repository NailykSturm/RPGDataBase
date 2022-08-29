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

import listener.bestiary.AddBestiaryAction;
import listener.bestiary.AddField;
import listener.bestiary.ResetBestiaryForm;
import model.bestiary.BestiaryForm;
import model.bestiary.BestiaryInfo;

public class BestiaryFormPanel extends JPanel {

    private static final String Add_MODE = "Add";
    private static final String Edit_MODE = "Edit";
    private JButton addButton;
    private JButton editButton;
    private HashMap<String, JTextField> bestiaryFormHashMap;
    private BestiaryForm bestiaryForm;
    private String mode;

    public BestiaryFormPanel(BestiaryMainPanel mainPanel, BestiaryInfo bestiary) {
        this.mode = Add_MODE;
        this.bestiaryForm = bestiary.getCurrentForm();
        this.bestiaryFormHashMap = bestiaryForm.getFields();
        addButton = new JButton("Add your entity to the bestiary");
        addButton.addActionListener(new AddBestiaryAction(mainPanel, bestiary));

        editButton = new JButton("Edit your entity in the bestiary");
        editButton.addActionListener(new AddBestiaryAction(mainPanel, bestiary));

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
        if(this.mode == Add_MODE) this.add(infoPanel(addButton), BorderLayout.NORTH);
        else this.add(infoPanel(editButton), BorderLayout.NORTH);
        this.add(scrollPanel(), BorderLayout.CENTER);
        this.add(addFieldPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void changeFormToEdit() {
        this.mode = Edit_MODE;
        this.refresh();
    }

    public void changeFormToAdd() {
        this.mode = Add_MODE;
        this.refresh();
    }

    public HashMap<String, JTextField> getBestiaryFormHashMap() {
        return bestiaryFormHashMap;
    }

    // Center panel for adding or editing fields in the bestiary
    private JScrollPane scrollPanel() {
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new GridBagLayout());
        JScrollPane scrollForm = new JScrollPane(scrollPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);

        for (String key : bestiaryFormHashMap.keySet()) {
            gbc.gridx = 0;
            gbc.gridy = -1;
            gbc.anchor = GridBagConstraints.LINE_END;
            scrollPanel.add(new JLabel(key), gbc);
            gbc.gridx = 1;
            gbc.gridy = -1;
            gbc.anchor = GridBagConstraints.CENTER;
            scrollPanel.add(bestiaryFormHashMap.get(key), gbc);
            gbc.gridx = 2;
            gbc.gridy = -1;
            gbc.anchor = GridBagConstraints.LINE_START;
            scrollPanel.add(new JButton("Delete field"), gbc);
        }
        return scrollForm;
    }

    // Northen information panel
    private JPanel infoPanel(JButton addOrEditButton) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("Form to add entity"), BorderLayout.CENTER);
        infoPanel.add(addOrEditButton, BorderLayout.WEST);
        JButton resetButton = new JButton("Reset form");
        resetButton.addActionListener(new ResetBestiaryForm(bestiaryForm, this));
        infoPanel.add(resetButton, BorderLayout.EAST);
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
