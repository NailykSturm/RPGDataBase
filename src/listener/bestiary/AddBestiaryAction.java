package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryFieldForm;
import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryMainPanel;

/**
 * Listener used to add an entity to the bestiary
 * 
 * @author NailykSturm
 */
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
        HashMap<String, BestiaryFieldForm> bestiaryFormFields = bestiaryPanel.getFormPanel().getBestiaryFormHashMap();
        for (String key : bestiaryFormFields.keySet()) {
            entityCharacteristics.put(key, bestiaryFormFields.get(key).getValue());
        }
        bestiary.addEntity(new BestiaryEntity(entityCharacteristics));
        bestiary.getCurrentForm().resetAllFields();
        bestiaryPanel.refresh();
    }
}
