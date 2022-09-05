package listener.rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.rpg.RPGControler;
import model.rpg.RPGInfo;
import view.common.AppTabbedPane;
import view.common.AppWindow;

/**
 * Listener used to change the RPG database
 * 
 * @author NailykSturm
 */
public class ChangeRPGDBAction implements ActionListener {

    private AppWindow appWindow;
    private RPGInfo rpg;

    public ChangeRPGDBAction(AppWindow appWindow, RPGInfo rpgInfo) {
        this.appWindow = appWindow;
        this.rpg = rpgInfo;
    }

    public void actionPerformed(ActionEvent e) {
        RPGControler rpgControler = appWindow.getRpg();
        rpgControler.setCurrent(rpg);

        appWindow.changeView(new AppTabbedPane(appWindow, rpgControler));
    }
}
