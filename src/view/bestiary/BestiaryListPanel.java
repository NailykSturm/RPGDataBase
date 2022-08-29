package view.bestiary;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BestiaryListPanel extends JPanel {
    

    public BestiaryListPanel() {
        this.setLayout(new BorderLayout());
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(mainPanel(), BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return this;
    }

    private JPanel infoPanel(){
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("List of entities"), BorderLayout.NORTH);
        return infoPanel;
    }

    private JPanel mainPanel(){
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.CYAN);
        return mainPanel;
    }
}
