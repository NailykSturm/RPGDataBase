package view.common;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import view.rpg.ListRPGMenu;

public class MenuPanel extends JPanel {

    // Menu bar
    public MenuPanel(AppWindow appWindow) {
        JMenu menu = new JMenu("Menu");
        JMenu changeDBMenu = new ListRPGMenu(appWindow, appWindow.getRpg());

        menu.add(changeDBMenu);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        this.setLayout(new BorderLayout());
        this.add(menuBar, BorderLayout.WEST);
    }
}
