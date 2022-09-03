package view.rpg;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.rpg.CancelValidateRPGAction;
import listener.rpg.ValidateRPGAction;
import view.common.AppWindow;
import view.common.MenuPanel;

/** 
 * View of the form for creating a new RPG
 * 
 * @author NailykSturm
 */
public class CreateRPGForm extends JPanel {

    private AppWindow appWindow;

    /**
     * Constructor of the class
     * @param appWindow parent window of this form
     */
    public CreateRPGForm(AppWindow appWindow) {
        this.appWindow = appWindow;
        this.setLayout(new BorderLayout());

        // Northen information panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new MenuPanel(appWindow), BorderLayout.WEST);
        infoPanel.add(new JLabel("Create RPG"), BorderLayout.CENTER);

        // Adding all elements to the panel
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(formPanel(), BorderLayout.CENTER);
    }

    // Center form panel
    private JPanel formPanel() {
        JTextField rpgName = new JTextField("Write your RPG name here");
        JButton validate = new JButton("Validate");
        validate.addActionListener(new ValidateRPGAction(appWindow, rpgName));
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new CancelValidateRPGAction(appWindow));

        JPanel form = new JPanel();
        form.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        form.add(rpgName, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        form.add(validate, c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        form.add(cancel, c);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BorderLayout());
        formPanel.setBackground(Color.BLACK);
        formPanel.add(form, BorderLayout.CENTER);

        return formPanel;
    }
}
