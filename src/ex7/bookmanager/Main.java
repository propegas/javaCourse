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
        bookManager.showMenu(BookManager.MAIN_MENU_INDEX);
        do {
            int userChoice = bookManager.getUserChoice();
        } while (true);
    }
}
