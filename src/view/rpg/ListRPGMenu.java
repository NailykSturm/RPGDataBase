package view.rpg;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controler.main.AddRPGAction;
import controler.rpg.ChangeRPGDBAction;
import model.rpg.RPGControler;
import model.rpg.RPGInfo;
import view.common.AppWindow;
import view.main.MenuWithoutRPG;

public class ListRPGMenu extends JMenu {

    // Create a menu when RPGs are found
    public ListRPGMenu(AppWindow appWindow, RPGControler rpgControler) {
        super("Change RPG DataBase");
        System.out.println("ListRPG => We will load all RPG");

        ArrayList<RPGInfo> infos = rpgControler.getRPGList();
        if (infos.size() == 0) {
            this.add(new MenuWithoutRPG(appWindow));
        } else {
            JMenu menu = new JMenu("List of RPG");
            JButton addRPG = new JButton("+ Create RPG");
            addRPG.addActionListener(new AddRPGAction(appWindow));
            menu.add(addRPG);

            for (int i = 0; i < infos.size(); i++) {
                JMenuItem item = new JMenuItem(infos.get(i).getName());
                item.addActionListener(new ChangeRPGDBAction(appWindow, infos.get(i)));
                menu.add(item);
            }
            this.add(menu);
        }
    }

    public JMenu getMenu() {
        return this;
    }
}
