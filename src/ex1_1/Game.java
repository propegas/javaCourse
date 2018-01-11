package ex1_1;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public abstract class Game {

    public static final int USER_VS_COMP = 0;
    public static final int USER_VS_USER = 1;
    public static final int COMP_VS_COMP = 2;
    public static final boolean  AUTO_CREATE_SHIPS = true;

    private int gameType;

    protected Game(int gameType) {
        this.gameType = gameType;
    }

    abstract void init();

    abstract void start();

    abstract boolean isEnd();

    abstract Player getWinner();

    abstract void finish();

    abstract void nextPlayerMove();

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

}
