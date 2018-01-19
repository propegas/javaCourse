package dz6;

/**
 * Created by vgoryachev on 17.01.2018.
 * Package: dz6.
 */
public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat();
        Animal cat2 = new Cat();
        Animal cat3 = new Cat();
        Animal dog1 = new Dog();
        Animal dog2 = new Dog();

        cat1.run(150);
        cat1.jump(1.5);
        cat2.swim(50);
        cat2.jump(2.1);
        cat3.run(300);

        dog1.run(400);
        dog1.swim(100);
        dog1.jump(1.1);
        dog2.jump(0.1);
    }
}
