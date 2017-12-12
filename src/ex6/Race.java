package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Race {

    public static final int HORSES_IN_RACE = 10;
    public static final int TOTAL_RACE_DISTANCE = 200;

    private int totalDistance;
    private Horse[] horses;
    private Horse[] horsesSortedByTotalDistance;

    public Race() {
        this.totalDistance = TOTAL_RACE_DISTANCE;
        initHorses();
    }

    public void initHorses() {
        this.horses = new Horse[HORSES_IN_RACE];
        this.horsesSortedByTotalDistance = new Horse[HORSES_IN_RACE];
        for (int i = 0; i < HORSES_IN_RACE; i++) {
            Horse horse = new Horse(i + 1);
            this.horses[i] = horse;
            this.horsesSortedByTotalDistance[i] = horse;
        }
    }

    public void showHorses() {
        for (int i = 0; i < this.horses.length; i++) {
            System.out.println(this.horses[i]);
        }
    }

    public void start() {
        System.out.println("Гонка началась!");
        do {
            raceLoop();
        } while (this.horsesSortedByTotalDistance[0].getTotalDistancePassed() < this.totalDistance);

        finish();
    }

    private void finish() {
        System.out.println("Гонка завершена!");
        showResult();
    }

    private void showResult() {
        Horse[] sortedHorses = this.horsesSortedByTotalDistance;
        System.out.println("Победила лошадь " + sortedHorses[0]);
        for (int i = 0; i < sortedHorses.length; i++) {
            Horse horse = sortedHorses[i];
            System.out.printf("%d место: \t%s%n", i + 1, horse);
        }
    }

    private void raceLoop() {
        System.out.println();
        for (int i = 0; i < this.horses.length; i++) {
            this.horses[i].move();
            showHorseIntermediateResult(this.horses[i]);
        }
        sortHorsesByDistance();
    }

    private void showHorseIntermediateResult(Horse horse) {
        System.out.printf("%s \tпрошла \t%d \tметров%n", horse, horse.getLastIterationDistancePassed());
    }

    void sortHorsesByDistance() {
        for (int i = 0; i < this.horses.length; i++) {
            for (int j = i + 1; j < this.horses.length; j++) {
                if (this.horsesSortedByTotalDistance[i].getTotalDistancePassed() <= this.horsesSortedByTotalDistance[j].getTotalDistancePassed()) {
                    Horse tmp = this.horsesSortedByTotalDistance[j];
                    this.horsesSortedByTotalDistance[j] = this.horsesSortedByTotalDistance[i];
                    this.horsesSortedByTotalDistance[i] = tmp;
                }
            }
        }
    }

    public Horse getWinner() {
        return this.horsesSortedByTotalDistance[0];
    }
}