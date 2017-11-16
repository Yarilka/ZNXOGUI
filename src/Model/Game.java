package Model;

import Controller.Controller;
import Model.Players.AiPlayer;
import Model.Players.HumanPlayer;
import Model.Players.Player;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.util.Random;

public class Game {
    private static Random rand = new Random();
    private static Alert alert = new Alert(Alert.AlertType.INFORMATION);

    static Controller controller = new Controller();
    private static Map map;

    public static void createMap(int lenght, int dot) {
        map = new Map(lenght, dot);
    }

    private static void alert(String mes) {
        alert.setTitle("Конец игры!");
        alert.setHeaderText(null);
        alert.setContentText(mes);
        alert.showAndWait();
        map.init();
    }

    private static void game(int x, int y) {
        Player p1 = new HumanPlayer("X", "Человек");
        Player p2 = new AiPlayer("O", "AI");

        p1.turn(x, y, map);

        if (win(p1.getXout(), p1.getYout(), p1.getSymb())) alert("Победил" + p1.getType());

        if (!(fullMap())) alert("Карта заполнена - ничья!");

        x = rand.nextInt(map.getSIZE());
        y = rand.nextInt(map.getSIZE());

        p2.turn(x, y, map);

        if (win(p2.getXout(), p2.getYout(), p2.getSymb())) alert("Победил" + p2.getType());

        if (!(fullMap())) alert("Карта заполнена - ничья!");
    }

    static void action(ActionEvent actionEvent) {
        for (int x = 0; x < map.getMapArr().length; x++)
            for (int y = 0; y < map.getMapArr().length; y++)
                if (actionEvent.getSource().equals(map.getMapArr()[x][y]))
                    if (map.getMapArr()[x][y].getText().equals(map.getEmpty())) {
                        game(x,y);
                    }
    }

    public static boolean cellEmpty(int x, int y) {
        return map.getMapArr()[x][y].getText().equals(map.getEmpty());
    }

    public static void setXO(int x, int y, String symb) {
        map.getMapArr()[x][y].setText(symb);
    }

    public static boolean win(int x, int y, String symb) {
        if (checkLine(x, y - map.getDOT_TO_WIN()+ 1, 0, 1, symb)) return true; //вертикаль
        if (checkLine(x - map.getDOT_TO_WIN() + 1, y - map.getDOT_TO_WIN() + 1, 1, 1, symb)) return true; //диагональ вправо-вниз
        if (checkLine(x - map.getDOT_TO_WIN() + 1, y, 1, 0, symb)) return true; //горизонталь
        if (checkLine(x - map.getDOT_TO_WIN() + 1, y + map.getDOT_TO_WIN() - 1, 1, -1, symb)) return true; //диагональ вправо-вверх
        return false;
    }

    private static boolean checkLine(int cx, int cy, int vx, int vy, String symb) {
        for (int j = 0; j < map.getDOT_TO_WIN(); j++) {
            int w = 0;
            for (int i = 0; i < map.getDOT_TO_WIN(); i++) {
                if (cx + i * vx < map.getSIZE() && cy + i * vy < map.getDOT_TO_WIN() && cx + i * vx > -1 && cy + i * vy > -1) {
                    if (!(map.getMapArr()[cx + i * vx][cy + i * vy].getText().equals(symb))) break;
                    w++;
                    if (w == map.getDOT_TO_WIN()) return true;
                }
            }
            cx += vx;
            cy += vy;
        }
        return false;
    }

    public static boolean  fullMap() {
        for (int i = 0; i < map.getSIZE(); i++) {
            for (int j = 0; j < map.getSIZE(); j++) {
                if (map.getMapArr()[j][i].getText().equals(map.getEmpty())) return true;
            }
        }
        return false;
    }
}
