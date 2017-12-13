package ex7.bookmanager;

/**
 * Created by vgoryachev on 13.12.2017.
 * Package: ex7.bookmanager.
 */
public class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }
}
