package ex1_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class SeaBattle extends Game {

    public static final int TABLE_SIZE = 10;
    private static final short MAX_SHIP_SIZE = 4;
    private static final short MAX_SHIPS_COUNT_BY_PLAYER = 6;

    private static SeaBattle currentGameInstance;

    private Player currentPlayer;
    private boolean autoCreateShips;
    private List<Player> playerList = new ArrayList<>(2);
    private GameView gameView = new GameView();

    private SeaBattle(int gameType, boolean autoCreateShips) {
        super(gameType);
        this.autoCreateShips = autoCreateShips;
    }

    public static SeaBattle getInstance(int gameType, boolean autoCreateShips) {
        if (currentGameInstance == null) {
            currentGameInstance = new SeaBattle(gameType, autoCreateShips);
        }
        return currentGameInstance;
    }

    @Override
    public void init() {
        for (Player player : playerList) {
            if (!player.isComp()) {
                String userNameForPlayer = gameView.getNameFromUser(player.getId());
                player.setName(userNameForPlayer);
            }

            if (autoCreateShips) {
                while (player.getField().getShips().getShipList().size() < MAX_SHIPS_COUNT_BY_PLAYER) {
                    player.getField().addRandomShip(MAX_SHIP_SIZE, TABLE_SIZE);
                }
            }

            gameView.showField(player);

        }

    }

    @Override
    public void start() {
        this.currentPlayer = playerList.get(0);
    }

    @Override
    boolean isEnd() {
        return false;
    }

    @Override
    Player getWinner() {
        return null;
    }

    @Override
    void finish() {

    }

    @Override
    void nextPlayerMove() {
        gameView.showNextPlayerMoveGreeting(currentPlayer);
        gameView.showField(currentPlayer);
        for (Player player : playerList) {
            if (player != currentPlayer) {
                gameView.showField(player, false);
            }
        }
    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
