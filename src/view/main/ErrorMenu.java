package view.main;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ErrorMenu extends JMenu {

    // Create a menu when a error happend
    public ErrorMenu(String string) {
        super("Change RPG DB");
        this.add(new JMenuItem(string));
    }

    public JMenu getMenu() {
        return this;
    }
}
