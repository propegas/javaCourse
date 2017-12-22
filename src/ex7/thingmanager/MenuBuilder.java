package ex7.thingmanager;

public class MenuBuilder {
    public static final int MAIN_MENU_INDEX = 100;
    public static final int MAIN_BOOK_MENU_INDEX = 200;
    public static final int MAIN_MAGNET_MENU_INDEX = 300;
    public static final int MAIN_DELETE_MENU_INDEX = 400;

    // main
    public static final int SHOW_ALL_MENU_ELEMENT_ID = 0;
    public static final int MANAGE_BOOKS_MENU_ELEMENT_ID = 1;
    public static final int MANAGE_MAGNETS_MENU_ELEMENT_ID = 2;
    public static final int DELETE_ALL_MENU_ELEMENT_ID = 3;
    public static final int DELETE_THING_MENU_ELEMENT_ID = 4;

    // book
    public static final int BOOK_ADD_MENU_ELEMENT_ID = 1;

    // magnet
    public static final int MAGNET_ADD_MENU_ELEMENT_ID = 1;

    // delete
    public static final int THING_DELETE_BY_ID_MENU_ELEMENT_ID = 1;

    public MenuBuilder() {
        //default
    }

    Menu createMainMenu() {
        Menu mainMenu = new Menu(5);

        Menu mainBookMenu = createMainBookMenu();
        mainBookMenu.addDefaultElement(mainMenu);

        Menu mainMagnetMenu = createMainMagnetMenu();
        mainMagnetMenu.addDefaultElement(mainMenu);

        Menu deleteByIdMenu = createDeleteByIdMenu();
        deleteByIdMenu.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню управления вещами.");
        mainMenu.setMenuType(MAIN_MENU_INDEX);
        mainMenu.getMenuElements()[0] = new MenuElement(SHOW_ALL_MENU_ELEMENT_ID, "Список вещей", null,
                "");
        mainMenu.getMenuElements()[1] = (new MenuElement(MANAGE_BOOKS_MENU_ELEMENT_ID, "Управление книгами", mainBookMenu, ""));
        mainMenu.getMenuElements()[2] = (new MenuElement(MANAGE_MAGNETS_MENU_ELEMENT_ID, "Управление магнитами", mainMagnetMenu, ""));
        mainMenu.getMenuElements()[3] = (new MenuElement(DELETE_ALL_MENU_ELEMENT_ID, "Удалить все вещи", null, "Хранилище очищено."));

        mainMenu.getMenuElements()[4] = (new MenuElement(DELETE_THING_MENU_ELEMENT_ID, "Удалить вещь", deleteByIdMenu, ""));

        return mainMenu;
    }

    private Menu createDeleteByIdMenu() {
        Menu mainMenu = new Menu(2);

        Menu menuDeleteById = new Menu(1);
        menuDeleteById.setMenuTitle("Вы находитесь в меню удаления вещи по ID.");
        menuDeleteById.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню удаления вещей.");
        mainMenu.setMenuType(MAIN_DELETE_MENU_INDEX);
        mainMenu.getMenuElements()[1] = new MenuElement(THING_DELETE_BY_ID_MENU_ELEMENT_ID, "Удалить вещь по ID", null,
                "Вещь удалена.");
        return mainMenu;
    }

    private Menu createMainMagnetMenu() {
        Menu mainMenu = new Menu(2);

        Menu menuAddBook = new Menu(1);
        menuAddBook.setMenuTitle("Вы находитесь в меню добавления магнита. ");
        menuAddBook.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню управления магнитами.");
        mainMenu.setMenuType(MAIN_MAGNET_MENU_INDEX);
        mainMenu.getMenuElements()[1] = new MenuElement(MAGNET_ADD_MENU_ELEMENT_ID, "Добавить магнит", null,
                "Новый магнит добавлен.");
        return mainMenu;
    }

    private Menu createMainBookMenu() {
        Menu mainMenu = new Menu(2);

        Menu menuAddBook = new Menu(1);
        menuAddBook.setMenuTitle("Вы находитесь в меню добавления новой книги. ");
        menuAddBook.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню управления книгами.");
        mainMenu.setMenuType(MAIN_BOOK_MENU_INDEX);
        mainMenu.getMenuElements()[1] = new MenuElement(BOOK_ADD_MENU_ELEMENT_ID, "Добавить книгу", null,
                "Новая книга добавлена.");

        return mainMenu;
    }
}