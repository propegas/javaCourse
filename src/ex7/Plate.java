package ex7;

/**
 * Created by vgoryachev on 07.12.2017.
 * Package: ex7.
 */
public class Plate {

    int amount;

    public Plate(int amount) {
        this.amount = amount;
    }

    public void eat(int amount) {
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
