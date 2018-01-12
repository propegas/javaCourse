package ex1_2;

/**
 * Created by vgoryachev on 12.01.2018.
 * Package: ex1_2.
 */
public class Main {

    public static void main(String[] args) {
        move(new Flyable() {
            @Override
            public void fly() {
                System.out.println("Ого!");
            }

            @Override
            public void landing() {
                System.out.println("Плюх!");
            }
        });
    }

    public static void move(Flyable flyable) {
        flyable.fly();
        flyable.landing();
    }
}
