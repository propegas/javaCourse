package ex7.bookmanager;

/**
 * Created by vgoryachev on 12.12.2017.
 * Package: ex7.bookmanager.
 */
public class Thing {
    private int id;
    private static int lastId;

    public Thing() {
        increaseLastId();
        this.id = lastId;
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
}
