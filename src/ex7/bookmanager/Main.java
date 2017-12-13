package ex7.bookmanager;

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
        Menu mainMenu = new Menu(4);
        thingManager.createMainMenu(mainMenu);
        thingManager.setCurrentMenu(mainMenu);

        do {
            thingManager.showMenu();
            thingManager.getUserChoice();
        } while (true);
    }


}
