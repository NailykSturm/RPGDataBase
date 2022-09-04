package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import model.bestiary.BestiaryEntity;
import model.bestiary.BestiaryFieldForm;
import model.bestiary.BestiaryForm;
import model.bestiary.BestiaryInfo;
import view.bestiary.BestiaryFormPanel;
import view.bestiary.BestiaryMainPanel;

/** 
 * Listener used for editing an entity
 * 
 * @author NailykSturm
 */
public class EditBestiaryAction implements ActionListener {

    private BestiaryMainPanel bestiaryMainPanel;
    private BestiaryFormPanel bestiaryFormPanel;
    private BestiaryInfo bestiary;
    private BestiaryForm bestiaryForm;
    private BestiaryEntity entity;

    public EditBestiaryAction(BestiaryFormPanel formPanel, BestiaryMainPanel mainPanel, BestiaryInfo bestiary, BestiaryForm form,
            BestiaryEntity editEntity) {
        this.bestiaryMainPanel = mainPanel;
        this.bestiaryFormPanel = formPanel;
        this.bestiary = bestiary;
        this.bestiaryForm = form;
        this.entity = editEntity;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, BestiaryFieldForm> characs = bestiaryFormPanel.getBestiaryFormHashMap();
        HashMap<String, String> characsValue = new HashMap<>();
        for (String key : characs.keySet()) {
            characsValue.put(key, characs.get(key).getValue());
        }
        bestiary.editEntity(entity, characsValue);
        bestiaryForm.resetAllFields();
        bestiaryFormPanel.changeEntityToAdd();
        bestiaryMainPanel.refresh();
    }

}
