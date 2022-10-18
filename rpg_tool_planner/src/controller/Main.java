package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.rpg.RPGs;

public class Main extends Application {

    private static Scene scene;
    protected static RPGs rpgs; 

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        rpgs = new RPGs();
        rpgs.loadFromJson();
        scene = new Scene(loadFXML("welcome"), 1200, 860);
        primaryStage.setTitle("RPG Planner Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../view/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
