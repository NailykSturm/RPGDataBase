package view.rpg;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import listener.main.AddRPGAction;
import listener.rpg.ChangeRPGDBAction;
import model.rpg.RPGControler;
import model.rpg.RPGInfo;
import view.common.AppWindow;

public class ListRPGMenu extends JMenu {

    // Create a menu when RPGs are found
    public ListRPGMenu(AppWindow appWindow, RPGControler rpgControler) {
        super("Change RPG DataBase");

        ArrayList<RPGInfo> rpgs = rpgControler.getRPGList();
        if (rpgs.size() == 0) {
            JMenu menu = new JMenu("No RPG saved");
            JButton addRPG = new JButton("+ Create RPG");
            addRPG.addActionListener(new AddRPGAction(appWindow));
            menu.add(addRPG);
            this.add(menu);
        } else {
            JMenu menu = new JMenu("List of RPG");
            JButton addRPG = new JButton("+ Create RPG");
            addRPG.addActionListener(new AddRPGAction(appWindow));
            menu.add(addRPG);

            for (int i = 0; i < rpgs.size(); i++) {
                JMenuItem item = new JMenuItem(rpgs.get(i).getName());
                item.addActionListener(new ChangeRPGDBAction(appWindow, rpgs.get(i)));
                menu.add(item);
            }
            this.add(menu);
        }
    }

    public JMenu getMenu() {
        return this;
    }
}
