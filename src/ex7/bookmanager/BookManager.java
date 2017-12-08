package ex7.bookmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class BookManager {
    public static final int MAIN_MENU_INDEX = 0;
    public static final int ADD_BOOK_MENU_INDEX = 1;
    public static final int SEARCH_BOOK_MENU_INDEX = 2;
    static int totalBooks;
    static int currentMenu;
    ArrayList<Books> books;
    Menu[] menus;

    public BookManager() {
        this.books = new ArrayList<>();
        this.menus = new Menu[3];
        menus[MAIN_MENU_INDEX] = new Menu(MAIN_MENU_INDEX);
        menus[ADD_BOOK_MENU_INDEX] = new Menu(ADD_BOOK_MENU_INDEX);
        menus[SEARCH_BOOK_MENU_INDEX] = new Menu(SEARCH_BOOK_MENU_INDEX);
    }

    public void showMenu(int type) {
        Menu mainMenu = menus[type];
        mainMenu.showMenu();
        currentMenu = type;
    }

    public int getUserChoice() {
        System.out.println("Введите номер пунка меню:");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        return userChoice;
    }
}
