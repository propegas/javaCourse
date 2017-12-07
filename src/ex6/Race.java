package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Race {

    int totalDistance;
    Player player;

    Horse[] horses;

    public Race(int totalRaceDistance) {
        this.totalDistance = totalRaceDistance;
    }

    public Horse[] getHorses() {
        return horses;
    }

    public void addHorses(Horse[] horses) {
        this.horses = horses;
    }

    public void initHorses(int horsesInRace) {
        Horse[] horses = new Horse[horsesInRace];
        for (int i = 0; i < horsesInRace; i++) {
            Horse horse = new Horse(true, i + 1);
            horses[i] = horse;
        }
        addHorses(horses);
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

        for (int i = 0; i < horses.length; i++) {
            Horse horse = horses[i];
            int distancePassed = horse.increaseDistance();

        }
    }
}
