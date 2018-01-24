package ex1_1;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Main {
    public static void main(String[] args) {

        GameFactory gameFactory = new GameFactory(GameFactory.USER_VS_COMP, true);
        Game seaBattle = gameFactory.getGame();

        seaBattle.init();

        seaBattle.start();

        while (!seaBattle.isEnd()) {
            seaBattle.currentPlayerMove();
            seaBattle.setNextPlayer();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        seaBattle.finish();
    }
}
