package view.main;

import javax.swing.JButton;
import javax.swing.JMenu;

public class MenuWithoutRPG extends JMenu {

    // Create a menu when no RPG is found
    public MenuWithoutRPG() {
        super("No RPG saved");
        this.add(new JButton("+ Create RPG"));
    }

    public JMenu getMenu() {
        return this;
    }
}
