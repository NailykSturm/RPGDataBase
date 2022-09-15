package view.common;

import javax.swing.JTabbedPane;

import model.rpg.RPGControler;
import view.bestiary.BestiaryMainPanel;
import view.notebloc.NoteBlocMainPanel;
import view.script.ScriptMainPanel;

/**
 * View that contains all the tabs of the application
 * 
 * @author NailykSturm
 */
public class AppTabbedPane extends JTabbedPane {
    

    public AppTabbedPane(AppWindow app, RPGControler rpgControler) {
        BestiaryMainPanel bestiaryMainPanel = new BestiaryMainPanel(app, rpgControler.getCurrent().getBestiary());
        ScriptMainPanel scriptMainPanel = new ScriptMainPanel(rpgControler.getCurrent());
        NoteBlocMainPanel noteBlocMainPanel = new NoteBlocMainPanel();

        this.add("Bestiary", bestiaryMainPanel);
        this.add("Script", scriptMainPanel);
        this.add("NoteBloc", noteBlocMainPanel);
    }
}
