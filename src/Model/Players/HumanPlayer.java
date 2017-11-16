package Model.Players;

import Model.Game;
import Model.Map;

public class HumanPlayer extends Player {

    public HumanPlayer(String symb, String type) {
        this.symb = symb;
        this.type = type;
    }

    @Override
    public void turn(int x, int y, Map map) {
        if (Game.cellEmpty(x, y)) {
            Game.setXO(x, y, symb);
            xout = x;
            yout = y;
            turnP = "p2";
            Game.game();
        }
    }
}
