package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.RPG;
import model.RPGs;

public class ControllerWelcome {

    /*
     * ================================
     * ======== RPG Management ========
     * ================================
     */

    public void initialize() {
        updateRPGList();
    }

    @FXML
    private TextField new_rpg_name;
    @FXML
    private Label new_rpg_error_label;

    private RPGs rpgs = Main.rpgs;

    public void addRPG() {
        new_rpg_name.setStyle("");
        new_rpg_error_label.setText("");
        System.out.println("The RPG " + new_rpg_name.getText() + " will be created");
        try {
            rpgs.addRPG(new_rpg_name.getText());
            updateRPGList();
            new_rpg_name.setText("");
            rpgs.saveToJson();
        } catch (Exception e) {
            System.out.println("You didn't enter a name");
            new_rpg_name.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            new_rpg_error_label.setText("You didn't enter a name");
            new_rpg_error_label.setTextFill(Color.RED);
        }
    }

    @FXML
    private SplitMenuButton select_rpg_list;

    public void updateRPGList() {
        System.out.println("Updating RPG List");
        select_rpg_list.getItems().clear();
        for (RPG rpg : rpgs.getRPGs()) {
            MenuItem item = new MenuItem(rpg.getName());
            item.setOnAction(e -> {
                selectRPG(e);
            });
            select_rpg_list.getItems().add(item);
        }
    }

    public void selectRPG(ActionEvent e) {
        for (RPG rpg : rpgs.getRPGs()) {
            if (rpg.getName().equals(((MenuItem) e.getSource()).getText())) {
                rpgs.setCurrentRPG(rpg);
                System.out.println("The RPG " + rpg + " has been selected");
            }
        }

        try {
            Main.setRoot("main_tool");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
