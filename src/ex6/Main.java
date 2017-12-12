package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {

        Race race = new Race();

        // делаем ставку
        race.showHorses();
        Player player = new Player();
        player.setBetFromScreen();

        race.start();
        showPlayerResult(player, race);
    }

    private static void showPlayerResult(Player player, Race race) {
        if (player.getHorseNum() == race.getWinner().getNum()) {
            System.out.println("Поздравляем! Ваша ставка выиграла!");
            double prize = player.getPrize(race.getWinner());
            System.out.printf("Поздравляем! Вы выигрыли $%f %n", prize);
        } else {
            System.out.println("К сожалению, вы проиграли.");
        }
    }

}