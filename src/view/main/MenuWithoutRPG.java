package view.main;

import javax.swing.JButton;
import javax.swing.JMenu;

import controler.main.AddRPGAction;
import view.common.AppWindow;

public class MenuWithoutRPG extends JMenu {

    // Create a menu when no RPG is found
    public MenuWithoutRPG(AppWindow appWindow) {
        super("No RPG saved");
        JButton addRPG = new JButton("+ Create RPG");
        addRPG.addActionListener(new AddRPGAction(appWindow));
        this.add(addRPG);
    }

    public JMenu getMenu() {
        return this;
    }
}
