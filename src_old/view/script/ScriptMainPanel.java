package view.script;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.rpg.RPGInfo;

/**
 * Main panel of the script editor.
 * 
 * @author NailykSturm
 */
public class ScriptMainPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ScriptCanvas canvas;
    private ScriptFormPanel formPanel;

    public ScriptMainPanel(RPGInfo rpgInfo) {
        this.canvas = new ScriptCanvas(rpgInfo.getScript());
        this.formPanel = new ScriptFormPanel(rpgInfo, this);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0, 60, 200));
        this.add(canvas, BorderLayout.CENTER);
        this.add(formPanel, BorderLayout.SOUTH);
    }

    public void refresh() {
        canvas.refresh();
        formPanel.refresh();
    }
}
