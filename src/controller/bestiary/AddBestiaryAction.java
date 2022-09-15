package controller.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryFieldForm;
import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryFormPanel;
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
        BestiaryFormPanel bestiaryForm = bestiaryPanel.getFormPanel();
        HashMap<String, BestiaryFieldForm> bestiaryFormFields = bestiaryForm.getBestiaryFormHashMap();
        boolean isEntityValid = true;
        for (String key : bestiaryFormFields.keySet()) {
            isEntityValid = isEntityValid && bestiaryFormFields.get(key).isCorrectlyFilled();
            entityCharacteristics.put(key, bestiaryFormFields.get(key).getValue());
        }
        if (isEntityValid) {
            bestiary.addEntity(new BestiaryEntity(entityCharacteristics));
        bestiary.getCurrentForm().resetAllFields();
        bestiaryPanel.refresh();
        }else{
            System.out.println("AddBestiaryAction => Entity not valid !");
        }
    }
}
