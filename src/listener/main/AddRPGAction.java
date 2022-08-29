package listener.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.common.AppWindow;
import view.rpg.CreateRPGForm;

public class AddRPGAction implements ActionListener {

    private AppWindow appWindow;

    public AddRPGAction(AppWindow appWindow) {
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
