package controller.rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.rpg.RPGControler;
import view.common.AppTabbedPane;
import view.common.AppWindow;

/**
 * Listener used to create a new RPG database
 * 
 * @author NailykSturm
 */
public class ValidateRPGAction implements ActionListener {
    
    private AppWindow appWindow;
    private JTextField rpgNameField;
    
    public ValidateRPGAction(AppWindow appWindow, JTextField rpgNameField){
        this.appWindow = appWindow;
        this.rpgNameField = rpgNameField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        RPGControler rpgControler = appWindow.getRpg();
        if(!rpgNameField.getText().equals(""))
            rpgControler.addRPG(rpgNameField.getText());
        else
            System.out.println("Please enter a name for the RPG");
        appWindow.changeView(
            new AppTabbedPane(appWindow, rpgControler));
    }
}