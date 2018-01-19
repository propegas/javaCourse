package dz7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        int eatenFood = plate.getDiffFromPlate(appetite);
        if (eatenFood == appetite) {
            this.satiety = true;
            plate.decreaseFood(appetite);
        } else {
            this.satiety = false;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void info() {
        System.out.println("cat: " + name + " " + satiety);
    }
}
