package view.main;

import javax.swing.JMenu;

import model.main.RPG;

public class ListRPG extends JMenu {

    // Create a menu when RPGs are found
    public ListRPG(RPG rpg) {
        super("Change RPG DataBase");
        System.out.println("ListRPG => We will load all RPG");
        // TODO Load All RPG and create a menu item for each one
    }

    public JMenu getMenu() {
        return this;
    }
}
