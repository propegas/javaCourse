package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Race {

    int totalDistance;
    Player player;

    Horse[] horses;
    Horse[] horsesSortedByTotalDistance;

    public Race(int totalRaceDistance) {
        this.totalDistance = totalRaceDistance;
    }

    public void addHorses(Horse[] horses, Horse[] horsesSortedByTotalDistance) {
        this.horses = horses;
        this.horsesSortedByTotalDistance = horsesSortedByTotalDistance;
    }

    public void initHorses(int horsesInRace) {
        Horse[] horses = new Horse[horsesInRace];
        Horse[] horsesSortedByTotalDistance = new Horse[horsesInRace];
        for (int i = 0; i < horsesInRace; i++) {
            Horse horse = new Horse(true, i + 1);
            horses[i] = horse;
            horsesSortedByTotalDistance[i] = horse;
        }
        addHorses(horses, horsesSortedByTotalDistance);
    }

    public void showHorses() {
        for (int i = 0; i < horses.length; i++) {
            Horse horse = horses[i];
            System.out.println("Лошадь № " + horse.num);
        }
    }

    public void addPlayer(Player player) {
        this.player = player;
    }

    public void start() {
        System.out.println("Гонка началась!");
        do {
            raceLoop();
        } while (horsesSortedByTotalDistance[0].totalDistancePassed < totalDistance);

        finish();
    }

    private void finish() {
        System.out.println("Гонка завершена!");
        showResult();
    }

    private void showResult() {
        System.out.println("Победила лошадь %" + horsesSortedByTotalDistance[0].num);
        for (int i = 0; i < horsesSortedByTotalDistance.length; i++) {
            Horse horse = horsesSortedByTotalDistance[i];
            System.out.printf("%d место:\t Лошадь № %d%n", i + 1, horse.num);
        }
    }

    private void raceLoop() {
        for (int i = 0; i < horses.length; i++) {
            horses[i].move();
        }
        printIntermediateResult();
        sortHorsesByDistance();
    }

    private void printIntermediateResult() {
        System.out.println();
        for (int i = 0; i < horses.length; i++) {
            Horse horse = horses[i];
            System.out.printf("Лошадь № %d\t прошла %d\t метров%n", horse.num, horse.lastIterationDistancePassed);
        }
    }

    void sortHorsesByDistance() {
        for (int i = 0; i < horses.length; i++) {
            for (int j = i + 1; j < horses.length; j++) {
                if (horsesSortedByTotalDistance[i].totalDistancePassed <= horsesSortedByTotalDistance[j].totalDistancePassed) {
                    Horse tmp = horsesSortedByTotalDistance[j];
                    horsesSortedByTotalDistance[j] = horsesSortedByTotalDistance[i];
                    horsesSortedByTotalDistance[i] = tmp;
                }
            }
        }
    }

    public void showPlayerResult() {
        if (player.horseNum == horsesSortedByTotalDistance[0].num) {
            System.out.println("Поздравляем! Ваша ставка выиграла!");
        } else {
            System.out.println("К сожалению, вы проиграли.");
        }
    }
}