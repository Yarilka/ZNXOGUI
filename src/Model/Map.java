package Model;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import static Model.Game.controller;

public class Map {
    private Button[][] mapArr = null;
    private final int SIZE;
    private final int DOT_TO_WIN;
    private final String empty = " ";

    public int getSIZE() {
        return SIZE;
    }

    public Button[][] getMapArr() {
        return mapArr;
    }

    public int getDOT_TO_WIN() {
        return DOT_TO_WIN;
    }

    public String getEmpty() {
        return empty;
    }

    Map(int SIZE, int DOT_TO_WIN) {
        this.SIZE = SIZE;
        this.DOT_TO_WIN = DOT_TO_WIN;
        init();
    }

    public void init() {
        mapArr = new Button[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapArr[j][i] = new Button(empty);
                mapArr[j][i].setFont(new Font(40));
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                controller.getGame_pole().add(mapArr[j][i], j, i);
                mapArr[j][i].prefWidth(50);
                mapArr[j][i].prefHeight(50);
                mapArr[j][i].setOnAction(Game::action);
            }
        }
        controller.getGame_pole().setHgap(5);
        controller.getGame_pole().setVgap(5);
    }

    public void clear() {
        controller.getGame_pole().getChildren().clear();
    }
}