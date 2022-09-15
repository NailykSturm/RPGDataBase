package view.rpg;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.main.AddRPGRequest;
import controller.rpg.ChangeRPGDBAction;
import model.rpg.RPGControler;
import model.rpg.RPGInfo;
import view.common.AppWindow;

/**
 * View of the menu for the RPG
 * 
 * @author NailykSturm
 */
public class ListRPGMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	/**
     * Create a menu whereas the lost of rpg 
     * @param appWindow parent window of the menu
     * @param rpgControler controler of the rpgs
     */
    public ListRPGMenu(AppWindow appWindow, RPGControler rpgControler) {
        super("Change RPG DataBase");

        ArrayList<RPGInfo> rpgs = rpgControler.getRPGList();
        if (rpgs.size() == 0) {
            JLabel info = new JLabel("No RPG saved");
            JButton addRPG = new JButton("+ Create RPG");
            addRPG.addActionListener(new AddRPGRequest(appWindow));
            this.add(info);
            this.add(addRPG);
        } else {
            JLabel info = new JLabel("List of RPG");
            JButton addRPG = new JButton("+ Create RPG");
            addRPG.addActionListener(new AddRPGRequest(appWindow));
            this.add(info);
            this.add(addRPG);

            for (int i = 0; i < rpgs.size(); i++) {
                JMenuItem item = new JMenuItem(rpgs.get(i).getName());
                item.addActionListener(new ChangeRPGDBAction(appWindow, rpgs.get(i)));
                this.add(item);
            }
        }
    }

    /**
     * Getter of the menu with the RPG list
     * @return the menu created for the rpgs
     */
    public JMenu getMenu() {
        return this;
    }
}
