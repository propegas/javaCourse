package dz7;

/**
 * Created by vgoryachev on 19.01.2018.
 * Package: dz7.
 */
public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        Cat cat1 = new Cat("Barsik", 4);
        Cat cat2 = new Cat("Barsik2", 7);
        Cat cat3 = new Cat("Murzik1", 2);
        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = cat3;
        Plate plate = new Plate(11);
        plate.info();
        for (int i = 0; i < cats.length; i++) {
            Cat cat = cats[i];
            cat.eat(plate);
            plate.info();
        }

    }
}
