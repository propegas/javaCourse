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

    public Menu() {
        this.menuElements = new ArrayList<>();
    }

    public Menu(int mainIndex) {
        this();
        switch (mainIndex) {
            case BookManager.MAIN_MENU_INDEX:
                createMainMenu();
                break;
            case BookManager.ADD_BOOK_MENU_INDEX:
                createAddBookMenu();
                break;
            case BookManager.SEARCH_BOOK_MENU_INDEX:
                createSearchBookMenu();
                break;
            default:
                System.out.println("Неверный номер меню!");
        }
    }

    private void createAddBookMenu() {
        this.menuTitle = "Вы находитесь в меню добавления новой книги.";
        addDefaultElement();
    }

    private void addDefaultElement() {
        this.menuElements.add(new MenuElement(0, "Выйти в главное меню"));
    }

    private void createSearchBookMenu() {
        this.menuTitle = "Вы находитесь в меню поиска книги.";
        this.menuElements.add(new MenuElement(1, "Найти по номеру (id)"));
        this.menuElements.add(new MenuElement(2, "Найти по названию"));
        addDefaultElement();
    }

    private void createMainMenu() {
        this.menuTitle = "Вы находитесь в главном меню.";
        this.menuElements.add(new MenuElement(1, "Добавить книгу"));
        this.menuElements.add(new MenuElement(2, "Найти книгу"));
        addDefaultElement();
    }

    public void showMenu() {
        System.out.println(this.menuTitle);
        for (MenuElement menuElement : this.menuElements) {
            System.out.printf("%d: %s %n", menuElement.id, menuElement.title);
        }
    }
}
