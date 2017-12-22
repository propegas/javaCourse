package ex7.thingmanager;

/**
 * Created by vgoryachev on 12.12.2017.
 * Package: ex7.bookmanager.
 */
public class Thing {
    private static int lastId;
    private int id;
    private int price;

    public Thing() {
        increaseLastId();
        this.id = lastId;
    }

    public Thing(int price) {
        this();
        this.price = price;
    }

    private static void increaseLastId() {
        lastId++;
    }

    public static int getLastId() {
        return lastId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
