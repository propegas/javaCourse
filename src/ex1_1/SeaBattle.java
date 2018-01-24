package ex1_1;

import java.util.List;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class SeaBattle extends Game {

    public static final int TABLE_SIZE = 10;
    private static final int MAX_SHIP_SIZE = 4;

    private static SeaBattle currentGameInstance;

    private Player currentPlayer;
    private boolean autoCreateShips;
    private List<Player> playerList;
    private GameView gameView;

    private SeaBattle(int gameType, boolean autoCreateShips, List<Player> playerList, GameView gameView) {
        super(gameType);
        this.autoCreateShips = autoCreateShips;
        this.playerList = playerList;
        this.gameView = gameView;
    }

    public static SeaBattle getInstance(int gameType, boolean autoCreateShips, List<Player> playerList, GameView gameView) {
        if (currentGameInstance == null) {
            currentGameInstance = new SeaBattle(gameType, autoCreateShips, playerList, gameView);
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
//                while (player.getField().getShips().getShipList().size() < MAX_SHIPS_COUNT_BY_PLAYER) {
                while (player.isNotAllShipsCreated()) {
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
    void currentPlayerMove() {
        gameView.showNextPlayerMoveGreeting(currentPlayer);
        gameView.showField(currentPlayer);
        for (Player player : playerList) {
            if (player != currentPlayer) {
                gameView.showField(player, false);
            }
        }

    }

    @Override
    public void setNextPlayer() {
        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            if (player == currentPlayer) {
                if (i == playerList.size() - 1) {
                    i = -1;
                }
                this.currentPlayer = playerList.get(i + 1);
                return;
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
