package Model;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class Map {
    private Button[][] mapArr = null;
    private final int SIZE;
    private final int DOT_TO_WIN;
    private final String empty = " ";

    int getSIZE() {
        return SIZE;
    }

    Button[][] getMapArr() {
        return mapArr;
    }

    int getDOT_TO_WIN() {
        return DOT_TO_WIN;
    }

    String getEmpty() {
        return empty;
    }

    Map(int SIZE, int DOT_TO_WIN) {
        this.SIZE = SIZE;
        this.DOT_TO_WIN = DOT_TO_WIN;
    }

    void init(GridPane obj) {
        mapArr = new Button[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapArr[j][i] = new Button(empty);
                mapArr[j][i].setFont(new Font(30));
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapArr[j][i].setMinWidth(70);
                mapArr[j][i].setMinHeight(70);
                mapArr[j][i].setOnAction(Game::action);
                obj.add(mapArr[j][i], j, i);
            }
        }
        obj.setHgap(5);
        obj.setVgap(5);
    }
}