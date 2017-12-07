package ex6;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Horse {

    public static final SpeedRange MIN_SPEED_RANGE = new SpeedRange(5, 8);
    public static final SpeedRange MAX_SPEED_RANGE = new SpeedRange(12, 15);
    int num;
    int minSpeed;
    int maxSpeed;
    int totalDistancePassed = 0;
    int lastIterationDistancePassed = 0;

    public Horse(boolean randomSet, int horseNum) {
        if (!randomSet) {
            new Horse(horseNum);
        } else {
            createRandomHorse();
            this.num = horseNum;
        }

    }

    public Horse(int horseNum) {
        this.num = horseNum;
    }

    private void createRandomHorse() {
        this.minSpeed = (int) (Math.random() * (MIN_SPEED_RANGE.max - MIN_SPEED_RANGE.min + 1)) + MIN_SPEED_RANGE.min;
        this.maxSpeed = (int) (Math.random() * (MAX_SPEED_RANGE.max - MAX_SPEED_RANGE.min + 1)) + MAX_SPEED_RANGE.min;
    }

    public int increaseDistance() {
        int randomPassedDistance = (int) (Math.random() * (this.maxSpeed - this.minSpeed + 1)) + this.minSpeed;
        this.totalDistancePassed += randomPassedDistance;
        this.lastIterationDistancePassed += randomPassedDistance;
        return randomPassedDistance;
    }
}
