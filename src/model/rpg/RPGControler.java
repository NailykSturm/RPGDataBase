package model.rpg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * RPGControler class
 * Control of all the RPG in the RPGDataBase
 */
public class RPGControler implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<RPGInfo> rpgList;
    private RPGInfo current;

    public RPGControler () {
        rpgList = new ArrayList<RPGInfo>();
    }

    public void addRPG(String rpgName) {
        RPGInfo newRPG = new RPGInfo(rpgName);
        rpgList.add(newRPG);
        current = newRPG;
        saveRPG();
        System.out.println("RPG " + rpgName + " added");
    }

    public void saveRPG() {
        SaveRPG.saveRPGToFile(this);
    }

    public void removeRPG(RPGInfo rpg) {
        rpgList.remove(rpg);
        saveRPG();
        System.out.println("RPG " + rpg.getName() + " removed");
    }

    public ArrayList<RPGInfo> getRPGList() {
        return rpgList;
    }

    public String getCurrent() {
        return current.getName();
    }

    public void setCurrent(RPGInfo rpg) {
        current = rpg;
    }
}
