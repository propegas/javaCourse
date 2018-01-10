package ex1_1;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class GameFactory {
    private Game gameInstance;

    public GameFactory(int gameType, boolean autoCreateShips) {
        switch (gameType) {
            case Game.USER_VS_COMP:
                SeaBattle seaBattle = SeaBattle.getInstance(Game.USER_VS_COMP, autoCreateShips);
                List<Player> players = new ArrayList<>(2);
                players.add(new Player("noname", (short) 1, false));
                players.add(new Player("AI", (short) 2, true));
                seaBattle.setPlayerList(players);
                this.gameInstance = seaBattle;
        }
    }

    public Game getGame() {
        return gameInstance;
    }
}
