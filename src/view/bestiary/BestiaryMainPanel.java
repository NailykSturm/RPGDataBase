package view.bestiary;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.bestiary.BestiaryInfo;
import view.common.AppWindow;
import view.common.MenuPanel;

public class BestiaryMainPanel extends JPanel {

    private AppWindow appWindow;
    private BestiaryFormPanel bestiaryFormPanel;
    private BestiaryInfo bestiary;

    public BestiaryMainPanel(AppWindow appWindow, BestiaryInfo bestiaryInfo) {
        this.appWindow = appWindow;
        this.bestiary = bestiaryInfo;
        this.bestiaryFormPanel = new BestiaryFormPanel(this, bestiaryInfo);

        this.setLayout(new BorderLayout());

        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(bestiaryPanel(), BorderLayout.CENTER);
    }

    private JPanel infoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new MenuPanel(appWindow), BorderLayout.WEST);
        infoPanel.add(new JLabel("Bestiary of " + appWindow.getRpg().getCurrent()), BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.NORTH);
        return infoPanel;
    }

    private JPanel bestiaryPanel() {
        JPanel bestiaryPanel = new JPanel();
        bestiaryPanel.setLayout(new BorderLayout());
        bestiaryPanel.add(new BestiaryListPanel(bestiary, this).getPanel(), BorderLayout.CENTER);
        bestiaryPanel.add(bestiaryFormPanel.getPanel(), BorderLayout.EAST);
        return bestiaryPanel;
    }

    public void refresh() {
        bestiaryFormPanel.refresh();
        this.removeAll();
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(bestiaryPanel(), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public BestiaryFormPanel getFormPanel() {
        return this.bestiaryFormPanel;
    }
}
