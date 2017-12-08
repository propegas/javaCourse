package ex7.bookmanager;

import java.util.ArrayList;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Menu {
    String menuTitle;
    String menuFooter;
    ArrayList<MenuElement> menuElements;
    Menu previousMenu;

    public Menu() {
        this.menuElements = new ArrayList<>();
    }

    public Menu(int mainIndex) {
        this();
        switch (mainIndex) {
            case BookManager.MAIN_MENU_INDEX:
                createMainMenu();
                break;
           /* case BookManager.ADD_BOOK_MENU_INDEX:
                createAddBookMenu();
                break;
            case BookManager.SEARCH_BOOK_MENU_INDEX:
                createSearchBookMenu();
                break;*/
            default:
                System.out.println("Неверный номер меню!");
        }
    }

    public Menu(int addBookMenuIndex, Menu previousMenu) {
        this(addBookMenuIndex);
        this.previousMenu = previousMenu;
    }

    private void createAddBookMenu() {
        this.menuTitle = "Вы находитесь в меню добавления новой книги.";
        addDefaultElement(this);
    }

    private void addDefaultElement(Menu menu) {
        this.menuElements.add(new MenuElement(0, "Выйти в предыдущее меню", menu));
    }

   /* private void createSearchBookMenu() {
        this.menuTitle = "Вы находитесь в меню поиска книги.";
        this.menuElements.add(new MenuElement(1, "Найти по номеру (id)", menuAddBook));
        this.menuElements.add(new MenuElement(2, "Найти по названию", menuAddBook));
        addDefaultElement(this);
    }*/

    private void createMainMenu() {
        this.menuTitle = "Вы находитесь в главном меню.";

        Menu menuSearchBook = new Menu();
        menuSearchBook.menuTitle ="Вы находитесь в меню поиска книги.";
        menuSearchBook.previousMenu = this;
        menuSearchBook.menuElements.add(new MenuElement(1, "Найти по номеру (id)", null));
        menuSearchBook.menuElements.add(new MenuElement(2, "Найти по названию", null));
        menuSearchBook.addDefaultElement(this);

        Menu menuAddBook = new Menu();
        menuAddBook.menuTitle ="Вы находитесь в меню добавления новой книги.";
        menuAddBook.previousMenu = this;
        menuAddBook.addDefaultElement(this);

        this.menuElements.add(new MenuElement(1, "Добавить книгу", menuAddBook));
        this.menuElements.add(new MenuElement(2, "Найти книгу", menuSearchBook));
    }

    public void showMenu() {
        System.out.println(this.menuTitle);
        for (MenuElement menuElement : this.menuElements) {
            System.out.printf("%d: %s %n", menuElement.id, menuElement.title);
        }
    }
}
