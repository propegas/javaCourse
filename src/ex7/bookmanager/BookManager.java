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
    static int previousMenu = 0;
    Menu currentMenu;
    ArrayList<Books> books;
    Menu menu;

    public BookManager() {
        this.books = new ArrayList<>();
        this.menu = new Menu();
        this.currentMenu = menu;
        Menu mainMenu = new Menu(MAIN_MENU_INDEX);
/*        menus[MAIN_MENU_INDEX] = mainMenu;
        menus[ADD_BOOK_MENU_INDEX] = new Menu(ADD_BOOK_MENU_INDEX, mainMenu);
        menus[SEARCH_BOOK_MENU_INDEX] = new Menu(SEARCH_BOOK_MENU_INDEX, mainMenu);*/
    }

    public void showMenu() {
        Menu mainMenu = currentMenu;
        mainMenu.showMenu();
    }

    public String getUserChoice() {
        System.out.println("Введите номер пунка меню:");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        currentMenu.showMenu();
        return "";
    }
}
