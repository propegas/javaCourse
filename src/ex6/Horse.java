package ex6;

import java.util.Random;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Horse {

    private static final SpeedRange MIN_SPEED_RANGE = new SpeedRange(5, 8);
    private static final SpeedRange MAX_SPEED_RANGE = new SpeedRange(12, 15);
    private int num;
    private double betRate;
    private int minSpeed;
    private int maxSpeed;
    private int totalDistancePassed = 0;
    private int lastIterationDistancePassed = 0;

    public Horse() {
        //default
    }

    public Horse(int horseNum) {
        createRandomHorse();
        this.num = horseNum;
    }

    private void createRandomHorse() {
        Random r = new Random();
        this.minSpeed = r.nextInt(MIN_SPEED_RANGE.max - MIN_SPEED_RANGE.min + 1) + MIN_SPEED_RANGE.min;
        this.maxSpeed = r.nextInt(MAX_SPEED_RANGE.max - MAX_SPEED_RANGE.min + 1) + MAX_SPEED_RANGE.min;
        this.betRate = ((float) this.maxSpeed / this.minSpeed) + ((float) this.maxSpeed * 0.1) + ((float) this.minSpeed * 0.3) - ((float) this.maxSpeed - this.minSpeed) / 2;
    }

    public void move() {
        Random r = new Random();
        int randomPassedDistance = r.nextInt(this.maxSpeed - this.minSpeed + 1) + this.minSpeed;
        this.totalDistancePassed += randomPassedDistance;
        this.lastIterationDistancePassed = randomPassedDistance;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getBetRate() {
        return this.betRate;
    }

    public int getTotalDistancePassed() {
        return this.totalDistancePassed;
    }

    public int getLastIterationDistancePassed() {
        return lastIterationDistancePassed;
    }

    @Override
    public String toString() {
        return "Лошадь №"
                + num +
                ",\t пройденная общая дистанция: " + totalDistancePassed;
    }
}