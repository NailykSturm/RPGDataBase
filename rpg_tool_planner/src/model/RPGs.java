package model;

import java.io.File;
import java.util.ArrayList;

/**
 * This class is a class that manage all RPGs created.
 */
public class RPGs {
    private ArrayList<RPG> rpgs;
    private RPG currentRPG;
    String saveFolder = "./save/";


    public RPGs() {
        rpgs = new ArrayList<RPG>();
        currentRPG = null;
    }

    public void addRPG(String name) throws Exception {
        if (name.equals("")) {
            throw new Exception("No Name");
        }
        RPG rpg = new RPG(name);
        rpgs.add(rpg);
        System.out.println("The rpg : " + rpg + " has been created");
    }

    public void removeRPG(RPG rpg) {
        rpgs.remove(rpg);
    }

    public ArrayList<RPG> getRPGs() {
        return rpgs;
    }

    public void setCurrentRPG(RPG rpg) {
        currentRPG = rpg;
    }

    public RPG getCurrentRPG() {
        return currentRPG;
    }

    public void saveToJson() {
        System.out.println("Saving RPGs to JSON");

        // Check if the save folder exist
        File f = new File(saveFolder);
        try {
            if (!f.exists()) {
                if (f.mkdir()) {
                    System.out.println("Directory is created!");
                } else {
                    System.out.println("Failed to create directory!");
                }
            }else {
                System.out.println("Directory already exist");
            }
        } catch (Exception e) {
            System.out.println("Error while creating directory");
            e.printStackTrace();
        }

        // Save alls rpg in their own files
        for (RPG rpg : rpgs) {
            rpg.toJson(saveFolder);
        }
    }

    public void loadFromJson(){
        System.out.println("Loading RPGs from JSON");

        File directory = new File(saveFolder);
        File[] files = directory.listFiles();
        for (File file : files) {
            System.out.println("file = " + file);
            if (file.isFile()) {
                System.out.println("Loading " + file.getName());
                RPG rpg = new RPG(file);
                rpgs.add(rpg);
            }
        }
    }
}
