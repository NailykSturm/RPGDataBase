package controller.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.common.AppWindow;
import view.rpg.CreateRPGForm;

/**
 * Listener used to request the creation of a new RPG database
 * 
 * @author NailykSturm
 */
public class AddRPGRequest implements ActionListener {

    private AppWindow appWindow;

    public AddRPGRequest(AppWindow appWindow) {
        this.appWindow = appWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        appWindow.getContentPane().removeAll();
        appWindow.getContentPane().add(new CreateRPGForm(appWindow));
        appWindow.getContentPane().revalidate();
        appWindow.getContentPane().repaint();
    }
}
