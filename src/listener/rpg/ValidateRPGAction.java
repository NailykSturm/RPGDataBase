package listener.rpg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.rpg.RPGControler;
import view.bestiary.BestiaryMainPanel;
import view.common.AppWindow;

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
        rpgControler.addRPG(rpgNameField.getText());

        appWindow.changeView(new BestiaryMainPanel(appWindow, rpgControler.getCurrent().getBestiary()));
    }
}