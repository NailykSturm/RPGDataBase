package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JTextField;

import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryMainPanel;

public class AddBestiaryAction implements ActionListener {

    private BestiaryMainPanel bestiaryPanel;
    private BestiaryInfo bestiary;

    public AddBestiaryAction(BestiaryMainPanel bestiaryPanel, BestiaryInfo bestiary) {
        this.bestiaryPanel = bestiaryPanel;
        this.bestiary = bestiary;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, String> entityCharacteristics = new HashMap<>();
        HashMap<String, JTextField> bestiaryFormFields = bestiaryPanel.getFormPanel().getBestiaryFormHashMap();
        for (String key : bestiaryFormFields.keySet()) {
            entityCharacteristics.put(key, bestiaryFormFields.get(key).getText());
        }
        bestiary.addEntity(new BestiaryEntity(entityCharacteristics));
        bestiary.getCurrentForm().resetAllFields();
        bestiaryPanel.refresh();
    }
}
