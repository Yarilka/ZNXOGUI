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

    public GridPane getGame_pole() {
        return game_pole;
    }

    @FXML
    public void gameStart(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(tri))
            Game.createMap(3, 3);
        else if (actionEvent.getSource().equals(pyat))
            Game.createMap(5, 4);
        else if (actionEvent.getSource().equals(vosem))
            Game.createMap(8, 5);
    }
}

