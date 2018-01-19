package dz6;

/**
 * Created by vgoryachev on 17.01.2018.
 * Package: dz6.
 */
public class Dog extends Animal {

    public Dog() {
        super.maxRunPath = 500;
        super.maxSwimPath = 10;
        super.maxJumpHeight = 0.5;
    }

    @Override
    void run(double runPath) {
        boolean flag = runPath > maxRunPath;
        System.out.println("run : " + flag);
    }

    @Override
    void swim(double swimPath) {
        boolean flag = swimPath > maxSwimPath;
        System.out.println("jump : " + flag);
    }

    @Override
    void jump(double height) {
        boolean flag = height > maxJumpHeight;
        System.out.println("jump : " + flag);
    }
}
