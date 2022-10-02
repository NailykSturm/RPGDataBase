package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import model.RPG;

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
                System.out.println(((MenuItem)e.getSource()).getText());
            });
            rpgMenu.getItems().add(item);
        }
    }

    /*
     * ================================
     * ====== BESTIARY CONTOLLER ======
     * ================================
     */

    public void addField() {
        System.out.println("You're adding a field");
    }

    /*
     * ================================
     * ======= SCRIPT CONTOLLER =======
     * ================================
     */

    /*
     * ================================
     * ====== NOTEBLOC CONTOLLER ======
     * ================================
     */
}
