package controler.rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.rpg.RPGControler;
import model.rpg.RPGInfo;
import view.bestiary.BestiaryMainPanel;
import view.common.AppWindow;

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
        System.out.println(e);

        appWindow.getContentPane().removeAll();
        appWindow.getContentPane().add(new BestiaryMainPanel(appWindow));
        appWindow.getContentPane().revalidate();
        appWindow.getContentPane().repaint();
    }
}
