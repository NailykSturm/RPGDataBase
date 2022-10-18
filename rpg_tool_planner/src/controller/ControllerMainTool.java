package controller;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.bestiary.Bestiary;
import model.bestiary.Field;
import model.rpg.RPG;

public class ControllerMainTool {

    private RPG rpg = Main.rpgs.getCurrentRPG();

    /*
     * ================================
     * ============= MAIN =============
     * ================================
     */

    @FXML
    private Menu rpgMenu;

    public void initialize() {
        rpgMenu.getItems().clear();
        for (RPG rpg : Main.rpgs.getRPGs()) {
            MenuItem item = new MenuItem(rpg.getName());
            item.setOnAction(e -> {
                System.out.println(((MenuItem) e.getSource()).getText());
                Main.rpgs.setCurrentRPG(rpg);
                updateFrame();
            });
            rpgMenu.getItems().add(item);
        }
        updateFieldList();
    }

    private void updateFrame() {
        this.rpg = Main.rpgs.getCurrentRPG();
        this.bestiary = rpg.getBestiary();
        updateFieldList();
    }

    /*
     * ================================
     * ====== BESTIARY CONTROLLER =====
     * ================================
     */

    @FXML
    private TextField name_field;
    @FXML
    private Label name_error;
    @FXML
    private CheckBox uniq_checkbox;
    @FXML
    private CheckBox req_checkbox;
    @FXML
    private CheckBox check_checkbox;
    @FXML
    private CheckBox count_checkbox;

    private Bestiary bestiary = rpg.getBestiary();

    public void addField() {
        name_field.setStyle("");
        name_error.setText("");
        System.out.println("The field " + name_field.getText() + " will be created");
        try {
            Field field = new Field(name_field.getText(), uniq_checkbox.isSelected(), req_checkbox.isSelected(),
                    check_checkbox.isSelected(), count_checkbox.isSelected());
            boolean uniqFound = false;

            uniqFound = isAlreadyCreated(field);

            if (!uniqFound) {
                System.out.println("You're adding a field");
                name_field.setText("");
                bestiary.addField(field);
                updateFieldList();
                Main.rpgs.saveToJson(Main.rpgs.getCurrentRPG());
            } else {
                System.out.println("This field already exists");
                name_field.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                name_error.setText("This field already exists");
                name_error.setTextFill(Color.RED);
            }

            uniq_checkbox.setSelected(false);
            req_checkbox.setSelected(false);
            check_checkbox.setSelected(false);
            count_checkbox.setSelected(false);
        } catch (Error e) {
            System.out.println(e.getMessage());
            name_field.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            name_error.setText(e.getMessage());
            name_error.setTextFill(Color.RED);
        }
    }

    private boolean isAlreadyCreated(Field field) {
        for (Field f : bestiary.getFields()) {
            if (f.getName().equals(field.getName())) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private VBox list_fields;

    private void updateFieldList() {
        list_fields.getChildren().clear();
        for (Field field : bestiary.getFields()) {
            try {
                Pane pane = FXMLLoader.load(Main.class.getResource("../view/fieldCell.fxml"));
                ObservableList<Node> children = pane.getChildren();
                int i = 0;

                for (Node node : children) {
                    if (node instanceof Label && node.getId().equals("lbTitle")) {
                        ((Label) node).setText(field.getName());
                    } else if (node instanceof TextField && node.getId().equals("lbDescription")) {
                        if (field.isACheckbox()) {
                            CheckBox checkbox = new CheckBox();
                            pane.getChildren().set(i, checkbox);
                        } else if (field.isACounter()) {
                            Spinner<Integer> spinner = new Spinner<Integer>(0, Integer.MAX_VALUE, 0);
                            pane.getChildren().set(i, spinner);
                        }
                    } else if (node instanceof Button && node.getId().equals("deleteFieldButton")) {
                        ((Button) node).setOnAction(e -> {
                            System.out.println("You're deleting a field");
                            bestiary.removeField(field);
                            updateFieldList();
                        });
                    } else if (node instanceof Button && node.getId().equals("editFieldButton")) {
                        ((Button) node).setOnAction(e -> {
                            System.out.println("You're editing a field");
                            updateFieldList();
                        });
                    }
                    i++;
                }
                String style = "";
                if (field.isUnique()) {
                    style += "-fx-background-color: #CCB100FF;";
                }
                if (field.isRequired()) {
                    style += "-fx-border-color: red ; -fx-border-width: 2px ; -fx-border-style: dotted ;";
                }
                pane.setStyle(style);
                list_fields.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Field List Updated\n");
    }

    public void addMonster() {
        System.out.println("You're adding a monster");
    }

    /*
     * ================================
     * ======= SCRIPT CONTROLLER ======
     * ================================
     */

    /*
     * ================================
     * ====== NOTEBLOC CONTROLLER =====
     * ================================
     */
}
