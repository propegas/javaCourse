package dz7;

/**
 * Created by vgoryachev on 19.01.2018.
 * Package: dz7.
 */
public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food = food - n;
    }

    public int getDiffFromPlate(int n) {
        int diff = food - n;
        if (diff < 0) {
            return -diff;
        } else {
            return n;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

