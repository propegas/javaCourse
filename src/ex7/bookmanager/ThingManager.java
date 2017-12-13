package ex7.bookmanager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class ThingManager {

    private static int totalThings;
    private static MenuBuilder menuBuilder = new MenuBuilder();
    private static ArrayList<Thing> things = new ArrayList<>();
    private BookManager bookManager = BookManager.getInstance();
    private MagnetManager magnetManager = MagnetManager.getInstance();
    private Menu currentMenu;

    public ThingManager() {
//        this.things = new ArrayList<>();
    }

    private static void decreaseTotal() {
        totalThings--;
    }

    public static void increaseTotal() {
        totalThings++;
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    public void showMenu() {
        Menu mainMenu = getCurrentMenu();
        mainMenu.showMenu();
    }

    public String getUserChoice() {
        System.out.printf("В менеджере зарегистрировано %d вещей %n", totalThings);
        System.out.println("Введите номер пунка меню:");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        Menu selectedMenu = getCurrentMenu().getMenuElements()[(userChoice)].getMenu();
        if (selectedMenu != null) {
            this.setCurrentMenu(selectedMenu);
        } else {
            System.out.println();

            switch (getCurrentMenu().getMenuType()) {
                case MenuBuilder.MAIN_MENU_INDEX:
                    prepareManageThings(getCurrentMenu().getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.MAIN_BOOK_MENU_INDEX:
                    bookManager.prepareManageBook(getCurrentMenu().getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.MAIN_MAGNET_MENU_INDEX:
                    magnetManager.prepareManageMagnet(getCurrentMenu().getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.SEARCH_BOOK_MENU_INDEX:
                    bookManager.prepareSearchBook(getCurrentMenu().getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.DELETE_BOOK_MENU_INDEX:
                    bookManager.prepareDeleteBook(getCurrentMenu().getMenuElements()[userChoice]);
                    break;
                default:

            }
        }

        return null;
    }

    private void prepareManageThings(MenuElement menuElement) {
        System.out.println(menuElement);
        if (menuElement.getId() == MenuBuilder.SHOW_ALL_MENU_ELEMENT_ID) {
            showAll();
        } else if (menuElement.getId() == MenuBuilder.DELETE_ALL_MENU_ELEMENT_ID) {
            deleteAll();
        }
    }

    private void deleteAll() {
        for (Iterator<Thing> iterator = getThings().iterator(); iterator.hasNext(); ) {
            removeThingFromManager(iterator);
        }
    }

    private void showAll() {
        for (Thing thing : getThings()) {
            System.out.println(thing);
        }
    }

    private void removeThingFromManager(Iterator<Thing> iterator) {
        iterator.remove();
        decreaseTotal();
    }

    public void removeThingFromManager(Thing thing) {
        getThings().remove(thing);
        decreaseTotal();
    }

    public Thing getThingById() {
        int id = Integer.parseInt(getStringFromUser("Введите ID предмета:"));
        Thing thing = findThingById(id);
        return thing;
    }

    public Thing findThingById(int id) {
        for (Thing thing : getThings()) {
            if (thing.getId() == id) {
                return thing;
            }
        }
        return null;
    }




    public Book getBookInfoFromUser() {
        String bookTitle = getStringFromUser("Веедите название книги:");
        String bookAuthor = getStringFromUser("Веедите автора книги:");
        Book newBook = new Book(bookAuthor, bookTitle);
        return newBook;
    }

    public String getStringFromUser(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        String stringInfo = scanner.nextLine();
        return stringInfo;
    }

    public void createMainMenu(Menu mainMenu) {

        menuBuilder.createMainMenu(mainMenu);
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
