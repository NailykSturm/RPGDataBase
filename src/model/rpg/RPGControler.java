package model.rpg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * RPGControler class
 * Control of all the RPG in the RPGDataBase
 * 
 * @author NailykSturm
 */
public class RPGControler implements Serializable {

    private static final long serialVersionUID = 10L;
    /** List of all the RPG */
    private ArrayList<RPGInfo> rpgList;
    /** Current RPG selected by the user */
    private RPGInfo current;

    /**
     * Constructor of the class
     */
    public RPGControler() {
        rpgList = new ArrayList<RPGInfo>();
    }

    /**
     * Add a new RPG to the list
     * @param rpgName the name of the new RPG
     */
    public void addRPG(String rpgName) {
        RPGInfo newRPG = new RPGInfo(this, rpgName);
        rpgList.add(newRPG);
        current = newRPG;
        saveRPG();
    }

    /**
     * Save all RPG to a file
     */
    public void saveRPG() {
        SaveRPG.saveRPGToFile(this);
    }

    /**
     * Remove one RPG from the list
     * @param rpg the RPG to remove
     */
    public void removeRPG(RPGInfo rpg) {
        rpgList.remove(rpg);
        saveRPG();
        System.out.println(rpg + " removed");
    }

    /**
     * Get the list of RPGs
     * @return all the RPGs
     */
    public ArrayList<RPGInfo> getRPGList() {
        return rpgList;
    }

    /**
     * Get the current RPG
     * @return the current RPG
     */
    public RPGInfo getCurrent() {
        return current;
    }

    /**
     * Set the current RPG when you change it
     * @param current the new current RPG
     */
    public void setCurrent(RPGInfo rpg) {
        current = rpg;
    }

    @Override
    public String toString() {
        String listRPG = "";
        for (RPGInfo rpg : rpgList) {
            listRPG += rpg + "\n";
        }
        return "========================\nRPGControler [ \n " + listRPG + "\n =========> current=" + current
                + "\n========================\n]";
    }

    /**
     * Function that check if every global variables are correctly initialized
     */
    public void checkIfEverythingIsLoaded() {
        for (RPGInfo rpg : rpgList) {
            rpg.checkIfEverythingIsLoaded(this);
        }
        if (current == null) current = rpgList.get(0);
    }
}
