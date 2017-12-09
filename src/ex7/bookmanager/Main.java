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
        BookManager bookManager = new BookManager();
        Menu mainMenu = new Menu(3);
        bookManager.createMainMenu(mainMenu);
        bookManager.menu = mainMenu;
        bookManager.currentMenu = mainMenu;

        do {
            bookManager.showMenu();
            bookManager.getUserChoice();
        } while (true);
    }


}
