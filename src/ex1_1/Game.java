package ex1_1;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public abstract class Game {

    private int gameType;

    protected Game(int gameType) {
        this.gameType = gameType;
    }

    abstract void init();

    abstract void start();

    abstract boolean isEnd();

    abstract Player getWinner();

    abstract void finish();

    abstract void currentPlayerMove();

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public abstract void setNextPlayer();
}
