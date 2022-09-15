package controller.rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.common.AppWindow;
import view.main.WelcomePanel;

/**
 * Listener used to cancel the validation of a RPG
 * 
 * @author NailykSturm
 */
public class CancelValidateRPGAction implements ActionListener {

    private AppWindow appWindow;

    public CancelValidateRPGAction(AppWindow appWindow) {
        this.appWindow = appWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        appWindow.getContentPane().removeAll();
        appWindow.getContentPane().add(new WelcomePanel());
        appWindow.getContentPane().revalidate();
        appWindow.getContentPane().repaint();
    }
    
}
