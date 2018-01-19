package dz6;

/**
 * Created by vgoryachev on 17.01.2018.
 * Package: dz6.
 */
public class Cat extends Animal {

    public Cat() {
        super.maxRunPath = 200;
        super.maxSwimPath = 0;
        super.maxJumpHeight = 2;
    }

    @Override
    void run(double runPath) {
        boolean flag = runPath > maxRunPath;
        System.out.println("run : " + flag);
    }

    @Override
    void swim(double swimPath) {
        System.out.println("Коты не умеют плавать!");
    }

    @Override
    void jump(double height) {
        boolean flag = height > maxJumpHeight;
        System.out.println("jump : " + flag);
    }
}
