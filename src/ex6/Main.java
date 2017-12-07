package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Main {

    public static final int HORSES_IN_RACE = 10;
    public static final int TOTAL_RACE_DISTANCE = 20;

    public static void main(String[] args) {
        System.out.println(new int[][]{{1,2,3},{4,5,6}}[1][2]);
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
    }

    private static void doRace(Race race) {

    }

}
