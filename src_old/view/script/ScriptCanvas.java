package view.script;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.script.ScriptControler;
import model.script.ScriptEvent;

/**
 * View of the canvas of the script editor.
 * 
 * @author NailykSturm
 */
public class ScriptCanvas extends JPanel {
    private static final long serialVersionUID = 1L;

    private ScriptControler script;

    public ScriptCanvas(ScriptControler script) {
        super();
        this.setBackground(new Color(206, 69, 35));
        this.script = script;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<ScriptEvent> events = script.getEvents();
        int maxHeight = this.getSize().height;
        int maxWidth = this.getSize().width;
        int drawHeight = maxHeight / 2;
        int drawWidth = maxWidth / 2;
        int shift = 20;

        for (int idEvent = 0; idEvent < events.size(); idEvent++) {
            ScriptEvent event = events.get(idEvent);
            g.setColor(Color.MAGENTA);
            int nbChars = event.toString().length();
            g.fillRoundRect(drawWidth, drawHeight, (int) (nbChars * 8), 30, 30, 30);
            g.setColor(Color.BLACK);
            g.drawString(event.toString(), (drawWidth + shift), (drawHeight + shift));
        }
    }

    public void refresh() {
        this.repaint();
        this.revalidate();
    }
}
