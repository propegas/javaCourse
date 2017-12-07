package ex7;

/**
 * Created by vgoryachev on 07.12.2017.
 * Package: ex7.
 */
public class Cat {
    static int count;
    static int plate;
    static int bowl;
    int id;
    Bowl bowlFromClass;
    Plate plateFromClass;

    public Cat() {
        count++;
        this.id = count;
    }

    public static void showCount() {
        System.out.println(count);
    }

    public void eat(int amount) {
        plate -= amount;
        System.out.printf("Кошка %d съела %d еды %n", id, amount);
        System.out.printf("В тарелке осталось %d еды %n", plate);
    }

    public void drink(int amount) {
        bowl -= amount;
        System.out.printf("Кошка %d выпила %d воды %n", id, amount);
        System.out.printf("В миске осталось %d еды %n", bowl);
    }

    public int showPlate() {
        return plate;
    }

    public int showBowl() {
        return bowl;
    }

    public void showId() {
        System.out.println(id);
    }
}
