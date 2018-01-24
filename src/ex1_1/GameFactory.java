package ex1_1;

import java.util.ArrayList;

/*
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class GameFactory {
    public static final int USER_VS_COMP = 0;
    public static final int USER_VS_USER = 1;
    public static final int COMP_VS_COMP = 2;
    public static final boolean AUTO_CREATE_SHIPS = true;
    public static final int MAX_SHIPS_COUNT_BY_PLAYER = 6;
    private Game gameInstance;

    public GameFactory(int gameType, boolean autoCreateShips) {
        switch (gameType) {
            case USER_VS_COMP:
                ArrayList<Player> playerList = new ArrayList<>(2);
                GameView gameView = new GameView();
                SeaBattle seaBattle = SeaBattle.getInstance(USER_VS_COMP, autoCreateShips, playerList, gameView);
                playerList.add(new Player("noname", (short) 1, false, MAX_SHIPS_COUNT_BY_PLAYER));
                playerList.add(new Player("AI", (short) 2, true, MAX_SHIPS_COUNT_BY_PLAYER));
                seaBattle.setPlayerList(playerList);
                this.gameInstance = seaBattle;
        }
    }

    public Game getGame() {
        return gameInstance;
    }
}
