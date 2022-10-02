package model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/*
 * This class represents a RPG.
 */
public class RPG {

    private static int nbRPG = 0;
    private int idRpg;
    private String name;

    public RPG(String name) {
        this.name = name;
        idRpg = nbRPG;
        nbRPG++;
    }

    /**
     * This method load a RPG from a JSON file.
     * @param file The folder where the file is saved.
     */
    public RPG(File file) {
        System.out.println("Loading RPG from JSON");
        System.out.println("Loading from folder " + file);

        Gson gson = new Gson();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(file));
            RPG data = gson.fromJson(jsonReader, RPG.class);
            jsonReader.close();
            System.out.println(data.toString());
            this.name = data.name;
            this.idRpg = data.idRpg;
            nbRPG++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("RPG loaded");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RPG n°"+ idRpg +" [name=" + name + "]";
    }

    /**
     * This method save the RPG in a JSON file.
     * @param folder The folder where the file will be saved.
     */
    public void toJson(String folder) {
        System.out.println("Saving RPG to JSON");
        String fileName = folder + idRpg + "_" + name + ".json";
        System.out.println("Saving to " + fileName);

        Gson gson = new Gson();
        try {
            JsonWriter jsonWriter = new JsonWriter(new FileWriter(fileName));
            gson.toJson(this, RPG.class, jsonWriter);
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
