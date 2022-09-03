package listener.bestiary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JTextField;

import model.bestiary.BestiaryEntity;
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
        HashMap<String, JTextField> characs = bestiaryFormPanel.getBestiaryFormHashMap();
        HashMap<String, String> newCharacs = new HashMap<String, String>();
        for (String key : characs.keySet()) {
            newCharacs.put(key, characs.get(key).getText());
        }
        bestiary.editEntity(entity, newCharacs);
        bestiaryForm.resetAllFields();
        bestiaryFormPanel.changeEntityToAdd();
        bestiaryMainPanel.refresh();
    }

}
