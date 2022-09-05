package view.bestiary;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.bestiary.BestiaryInfo;
import view.common.AppWindow;

/**
 * View of all the bestiary
 * Control the data showed
 * 
 * @author NailykSturm
 */
public class BestiaryMainPanel extends JPanel {

    private AppWindow appWindow;
    /** The form panel showed as child */
    private BestiaryFormPanel bestiaryFormPanel;
    /** The bestiary used */
    private BestiaryInfo bestiary;

    /**
     * Constructor 
     * @param appWindow Application main frame
     * @param bestiaryInfo the bestiary used for this RPG
     */
    public BestiaryMainPanel(AppWindow appWindow, BestiaryInfo bestiaryInfo) {
        this.appWindow = appWindow;
        this.bestiary = bestiaryInfo;
        this.bestiaryFormPanel = new BestiaryFormPanel(this, bestiaryInfo);

        this.setLayout(new BorderLayout());

        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(bestiaryPanel(), BorderLayout.CENTER);
    }

    /**
     * Create an information panel
     * @return the information panel created
     */
    private JPanel infoPanel() {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.add(new JLabel("Bestiary of " + appWindow.getRpg().getCurrent()), BorderLayout.CENTER);
        this.add(infoPanel, BorderLayout.NORTH);
        return infoPanel;
    }

    /**
     * Create a panel for the bestiary
     * @return this bestiary panel
     */
    private JPanel bestiaryPanel() {
        JPanel bestiaryPanel = new JPanel();
        bestiaryPanel.setLayout(new BorderLayout());
        bestiaryPanel.add(new BestiaryListPanel(bestiary, this).getPanel(), BorderLayout.CENTER);
        bestiaryPanel.add(bestiaryFormPanel.getPanel(), BorderLayout.EAST);
        return bestiaryPanel;
    }

    /**
     * Refresh all data showed
     */
    public void refresh() {
        bestiaryFormPanel.refresh();
        this.removeAll();
        this.add(infoPanel(), BorderLayout.NORTH);
        this.add(bestiaryPanel(), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    /**
     * getter of the form panel saved in the Main bestiary's panel
     * @return the form panel
     */
    public BestiaryFormPanel getFormPanel() {
        return this.bestiaryFormPanel;
    }
}
