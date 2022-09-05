package view.bestiary;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 * View of a field in the bestiary form.
 * 
 * @author NailykSturm
 */
public class BestiaryFieldFormPanel extends JPanel {
    
    public BestiaryFieldFormPanel(JTextField field) {
        this.setLayout(new BorderLayout());
        this.add(field, BorderLayout.CENTER);
    }

    public BestiaryFieldFormPanel(JCheckBox comboBox) {
        this.setLayout(new BorderLayout());
        this.add(comboBox, BorderLayout.CENTER);
    }

    public BestiaryFieldFormPanel(JSpinner spinner) {
        this.setLayout(new BorderLayout());
        this.add(spinner, BorderLayout.CENTER);
    }

    public BestiaryFieldFormPanel(JSlider slider) {
        this.setLayout(new BorderLayout());
        this.add(slider, BorderLayout.CENTER);
    }

    public JPanel getFieldPanel() {
        return this;
    }
}
