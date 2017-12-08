package ex7;

/**
 * Created by vgoryachev on 07.12.2017.
 * Package: ex7.
 */
public class Main {

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Cat cat1 = new Cat();
        cat1.showId();
        Cat cat2 = new Cat();
        cat2.showId();
        Cat cat3 = new Cat();
        cat3.showId();

        Cat.showCount();

        // eat from static :)
        Cat.plate = 100;
        Cat.bowl = 200;
        cat1.drink(5);
        cat2.drink(9);
        cat3.drink(2);
        cat1.eat(35);
        cat3.eat(45);

        System.out.println();
        // eat from classes :)
        Bowl bowl = new Bowl(100);
        Plate plate = new Plate(300);

        cat1.drinkFromBowl(bowl, 11);
        cat2.eatFromPlate(plate, 114);
        cat3.eatFromPlate(plate, 55);
        cat2.drinkFromBowl(bowl, 19);

    }

}
