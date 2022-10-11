package controller;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.bestiary.Field;
import model.rpg.RPG;

public class ControllerMainTool {

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
            });
            rpgMenu.getItems().add(item);
        }
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

    private ArrayList<Field> fields = new ArrayList<Field>();

    public void addField() {
        name_field.setStyle("");
        name_error.setText("");
        System.out.println("The field " + name_field.getText() + " will be created");
        Field field = new Field(name_field.getText(), uniq_checkbox.isSelected(), req_checkbox.isSelected(),
                check_checkbox.isSelected(), count_checkbox.isSelected());
        boolean uniqFound = false;

        uniqFound = isSameAsUniqFields(field);

        if (!uniqFound) {
            System.out.println("You're adding a field");
            name_field.setText("");
            fields.add(field);
            updateFieldList();
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
    }

    private boolean isSameAsUniqFields(Field field) {
        for (Field f : fields) {
            if ((f.isUnique() || field.isUnique()) && f.getName().equals(field.getName())) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private VBox list_fields;

    private void updateFieldList() {
        System.out.println("Updating Field List");
        list_fields.getChildren().clear();
        for (Field field : fields) {
            try {
                Pane pane = FXMLLoader.load(Main.class.getResource("../view/fieldCell.fxml"));
                System.out.println(pane.getChildren());
                Label name = (Label) pane.getChildren().get(0);
                name.setText(field.getName());

                list_fields.getChildren().add(pane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
