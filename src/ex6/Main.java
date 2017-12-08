package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Main {

    public static final int HORSES_IN_RACE = 10;
    public static final int TOTAL_RACE_DISTANCE = 200;

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        Race race = new Race(TOTAL_RACE_DISTANCE);
        race.initHorses(HORSES_IN_RACE);

        // делаем ставку
        race.showHorses();
        Player player = new Player();
        player.setBetFromScreen();

        race.addPlayer(player);

        race.start();
        race.showPlayerResult();
    }

}