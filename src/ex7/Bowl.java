package ex7;

/**
 * Created by vgoryachev on 07.12.2017.
 * Package: ex7.
 */
public class Bowl {
    int amount;

    public Bowl(int amount) {
        this.amount = amount;
    }

    public void drink(int amount) {
        this.amount -= amount;

    }

    public int getAmount() {
        return amount;
    }
}
