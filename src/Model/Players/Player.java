package Model.Players;

import Model.Map;

public abstract class Player {
    String symb;
    String type;
    public static String turnP = "p1";
    int xout, yout;

    public String getSymb() {
        return symb;
    }

    public String getType() {
        return type;
    }

    public int getXout() {
        return xout;
    }

    public int getYout() {
        return yout;
    }

    public abstract void turn(int x, int y, Map map);
}
