package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.common.AppWindow;
import view.common.MenuPanel;


public class BestiaryMainPanel extends JPanel{

    //private AppWindow appWindow;

    public BestiaryMainPanel(AppWindow appWindow) {
        //this.appWindow = appWindow;
        this.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new MenuPanel(appWindow), BorderLayout.WEST);
        infoPanel.add(new JLabel("Bestiary of " + appWindow.getRpg().getCurrent()), BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.NORTH);

        JPanel bestiaryPanel = new JPanel();
        bestiaryPanel.setLayout(new BorderLayout());
        bestiaryPanel.setBackground(Color.RED);
        this.add(bestiaryPanel, BorderLayout.CENTER);
    }
    
}
