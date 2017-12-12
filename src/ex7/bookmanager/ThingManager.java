package ex7.bookmanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class ThingManager {
    public static final int MAIN_BOOK_MENU_INDEX = 0;
    public static final int MAIN_MENU_INDEX = 1;
    public static final int DELETE_BOOK_MENU_INDEX = 2;
    public static final int BOOK_ADD_MENU_ELEMENT_ID = 1;
    public static final int SEARCH_BOOK_MENU_INDEX = 3;
    public static final int DELETE_ALL_MENU_ELEMENT_ID = 2;
    public static final int SHOW_ALL_MENU_ELEMENT_ID = 0;
    static int totalThings;
    private final MenuBuilder MenuBuilder = new MenuBuilder();
    Menu currentMenu;
    ArrayList<Thing> things;

    public ThingManager() {
        this.things = new ArrayList<>();
    }

    private static void decreaseTotal() {
        totalThings--;
    }

    private static void increaseTotal() {
        totalThings++;
    }

    public void showMenu() {
        Menu mainMenu = currentMenu;
        mainMenu.showMenu();
    }

    public String getUserChoice() {
        System.out.printf("В менеджере зарегистрировано %d вещей %n", totalThings);
        System.out.println("Введите номер пунка меню:");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        Menu selectedMenu = currentMenu.menuElements[(userChoice)].menu;
        if (selectedMenu != null) {
            this.currentMenu = selectedMenu;
        } else {
            System.out.println();

            switch (currentMenu.menuType) {
                case MAIN_MENU_INDEX:
                    prepareManageThings(currentMenu.menuElements[(userChoice)]);
                    break;
                case MAIN_BOOK_MENU_INDEX:
                    prepareManageBook(currentMenu.menuElements[(userChoice)]);
                    break;
                case SEARCH_BOOK_MENU_INDEX:
                    prepareSearchBook(currentMenu.menuElements[(userChoice)]);
                    break;
                case DELETE_BOOK_MENU_INDEX:
                    prepareDeleteBook(currentMenu.menuElements[(userChoice)]);
                    break;
                default:

            }
        }

        return null;
    }

    private void prepareManageThings(MenuElement menuElement) {
        System.out.println(menuElement);
        if (menuElement.id == SHOW_ALL_MENU_ELEMENT_ID) {
            //findBook = getBookById();
            showAll();
        } else if (menuElement.id == DELETE_ALL_MENU_ELEMENT_ID) {
            //findBook = getBookByTitle();
            deleteAll();
        }
    }

    private void deleteAll() {
        for (Iterator<Thing> iterator = things.iterator(); iterator.hasNext(); ) {
            removeThingFromManager(iterator);
        }
    }


    private void showAll() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    private void prepareDeleteBook(MenuElement menuElement) {
        Book findBook = null;
        if (menuElement.id == 1) {
            //findBook = getBookById();
        } else if (menuElement.id == 2) {
            findBook = getBookByTitle();
        }

        if (findBook != null) {
            System.out.printf("%s%n%n", findBook);
            removeThingFromManager(findBook);
            System.out.println(menuElement.result);
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    private void removeThingFromManager(Iterator<Thing> iterator) {
        iterator.remove();
        decreaseTotal();
    }

    private void removeThingFromManager(Thing thing) {
        things.remove(thing);
        decreaseTotal();
    }

    private void prepareSearchBook(MenuElement menuElement) {
        Book findBook = null;
        if (menuElement.id == 1) {
            //findBook = getBookById();
        } else if (menuElement.id == 2) {
            findBook = getBookByTitle();
        }

        if (findBook != null) {
            System.out.println(menuElement.result);
            System.out.printf("Автор: %s %nНазвание: %s%n%n", findBook.getAuthor(), findBook.getTitle());
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    private Book getBookByTitle() {
        Book findBook;
        String bookTitleToSearch = getBookTitleToSearchFromUser();
        findBook = findBookByTitle(bookTitleToSearch);
        return findBook;
    }

    private Book findBookByTitle(String bookTitleToSearch) {
        for (Thing thing : things) {
            if (((Book) thing).getTitle().equalsIgnoreCase(bookTitleToSearch)) {
                return (Book) thing;
            }
        }
        return null;
    }

    private String getBookTitleToSearchFromUser() {
        String title = getStringFromUser("Введите название книги:");
        return title;
    }

    private void prepareManageBook(MenuElement menuElement) {
        Book bookInfoFromUser;
        if (menuElement.id == BOOK_ADD_MENU_ELEMENT_ID) {
            bookInfoFromUser = getBookInfoFromUser();
            addBookToManager(bookInfoFromUser);
            System.out.println(menuElement.result);
        }

    }

    private void addBookToManager(Book bookInfoFromUser) {
        things.add(bookInfoFromUser);
        increaseTotal();
    }

    private Book getBookInfoFromUser() {
        String bookTitle = getStringFromUser("Веедите название книги:");
        String bookAuthor = getStringFromUser("Веедите автора книги:");
        Book newBook = new Book(bookAuthor, bookTitle);
        return newBook;
    }

    private String getStringFromUser(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        String stringInfo = scanner.nextLine();
        return stringInfo;
    }

    public void createMainMenu(Menu mainMenu) {

        MenuBuilder.createMainMenu(mainMenu);
    }

}
