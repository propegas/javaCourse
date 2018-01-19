package dz6;

/**
 * Created by vgoryachev on 17.01.2018.
 * Package: dz6.
 */
public abstract class Animal {

    double maxRunPath;
    double maxSwimPath;
    double maxJumpHeight;

    abstract void run(double runPath);
    abstract void swim(double swimPath);
    abstract void jump(double height);
}
