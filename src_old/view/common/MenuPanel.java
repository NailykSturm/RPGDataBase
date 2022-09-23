package view.common;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import view.rpg.ListRPGMenu;

/**
 * Class of the menu of the application
 * 
 * @author NailykSturm
 */
public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
     * Constructor
     * @param appWindow the main app's window
     */
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
