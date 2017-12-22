package ex7.thingmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {

        ThingManager thingManager = new ThingManager();
        User user = new User();

        Menu menu = new Menu(user, thingManager);
        menu.start();

    }

}
