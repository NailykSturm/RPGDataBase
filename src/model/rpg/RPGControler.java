package model.rpg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * RPGControler class
 * Control of all the RPG in the RPGDataBase
 */
public class RPGControler implements Serializable {

    private static final long serialVersionUID = 10L;
    private ArrayList<RPGInfo> rpgList;
    private RPGInfo current;

    public RPGControler() {
        rpgList = new ArrayList<RPGInfo>();
    }

    public void addRPG(String rpgName) {
        RPGInfo newRPG = new RPGInfo(rpgName);
        rpgList.add(newRPG);
        current = newRPG;
        saveRPG();
        System.out.println(newRPG + " added");
    }

    public void saveRPG() {
        SaveRPG.saveRPGToFile(this);
    }

    public void removeRPG(RPGInfo rpg) {
        rpgList.remove(rpg);
        saveRPG();
        System.out.println(rpg + " removed");
    }

    public ArrayList<RPGInfo> getRPGList() {
        return rpgList;
    }

    public RPGInfo getCurrent() {
        return current;
    }

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

    public void checkIfEverythingIsLoaded() {
        for (RPGInfo rpg : rpgList) {
            rpg.checkIfEverythingIsLoaded();
        }
        if (current == null) current = rpgList.get(0);
    }
}
