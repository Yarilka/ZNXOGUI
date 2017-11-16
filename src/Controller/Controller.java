package Controller;

import Model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML
    private Button tri;

    @FXML
    private Button pyat;

    @FXML
    private Button vosem;

    @FXML
    private GridPane game_pole;

    @FXML
    public void clickOnExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void gameStart(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(tri)) {
            clear();
            Game.createMap(3, 3, game_pole);
        } else if (actionEvent.getSource().equals(pyat)) {
            clear();
            Game.createMap(5, 4, game_pole);
        } else if (actionEvent.getSource().equals(vosem)) {
            clear();
            Game.createMap(8, 5, game_pole);
        }
    }

    public void clear() {
        game_pole.getChildren().clear();
    }

}

