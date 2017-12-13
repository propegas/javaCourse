package ex7.bookmanager;

public class MenuBuilder {
    public static final int MAIN_BOOK_MENU_INDEX = 0;
    public static final int MAIN_MENU_INDEX = 1;
    public static final int MAIN_MAGNET_MENU_INDEX = 2;
    public static final int DELETE_BOOK_MENU_INDEX = 4;
    public static final int BOOK_ADD_MENU_ELEMENT_ID = 1;
    public static final int SEARCH_BOOK_MENU_INDEX = 3;
    public static final int SEARCH_MAGNET_MENU_INDEX = 4;
    public static final int DELETE_MAGNET_MENU_INDEX = 5;
    public static final int DELETE_ALL_MENU_ELEMENT_ID = 3;
    public static final int SHOW_ALL_MENU_ELEMENT_ID = 0;
    public static final int MANAGE_MAGNETS_MENU_ELEMENT_ID = 2;
    public static final int MAGNET_ADD_MENU_ELEMENT_ID = 1;

    public MenuBuilder() {
        //default
    }

    void createMainMenu(Menu mainMenu) {
        Menu mainBookMenu = createMainBookMenu();
        mainBookMenu.addDefaultElement(mainMenu);

        Menu mainMagnetMenu = createMainMagnetMenu();
        mainBookMenu.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню управления вещами.");
        mainMenu.setMenuType(MAIN_MENU_INDEX);
        mainMenu.getMenuElements()[0] = new MenuElement(SHOW_ALL_MENU_ELEMENT_ID, "Список вещей", null,
                "");
        mainMenu.getMenuElements()[1] = (new MenuElement(1, "Управление книгами", mainBookMenu, ""));
        mainMenu.getMenuElements()[2] = (new MenuElement(MANAGE_MAGNETS_MENU_ELEMENT_ID, "Управление магнитами", mainMagnetMenu, ""));
        mainMenu.getMenuElements()[3] = (new MenuElement(DELETE_ALL_MENU_ELEMENT_ID, "Удалить все вещи", null, "Хранилище очищено."));
    }

    private Menu createMainMagnetMenu() {
        Menu mainMenu = new Menu(4);

        Menu menuSearchMagnet = new Menu(3);
        menuSearchMagnet.setMenuType(SEARCH_MAGNET_MENU_INDEX);
        menuSearchMagnet.setMenuTitle("Вы находитесь в меню поиска магнита.");
        menuSearchMagnet.getMenuElements()[1] = (new MenuElement(1, "Найти по номеру (id)", null, "Магнит найден."));
        menuSearchMagnet.getMenuElements()[2] = new MenuElement(2, "Найти по стране", null, "Магнит найдена.");
        menuSearchMagnet.addDefaultElement(mainMenu);

        Menu menuDeleteMagnet = new Menu(3);
        menuDeleteMagnet.setMenuType(DELETE_MAGNET_MENU_INDEX);
        menuDeleteMagnet.setMenuTitle("Вы находитесь в меню удаления книги.");
        menuDeleteMagnet.getMenuElements()[1] = (new MenuElement(1, "Удалить магнит по номеру (id)", null, "Магнит удален."));
        menuDeleteMagnet.getMenuElements()[2] = new MenuElement(2, "Удалить магнит по стране", null, "Магнит удален.");
        menuDeleteMagnet.addDefaultElement(mainMenu);

        Menu menuAddBook = new Menu(1);
        menuAddBook.setMenuTitle("Вы находитесь в меню добавления магнита. ");
        menuAddBook.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню управления магнитами.");
        mainMenu.setMenuType(MAIN_MAGNET_MENU_INDEX);
        mainMenu.getMenuElements()[1] = new MenuElement(BOOK_ADD_MENU_ELEMENT_ID, "Добавить магнит", null,
                "Новый магнит добавлен.");
        mainMenu.getMenuElements()[2] = (new MenuElement(2, "Найти магнит", menuSearchMagnet, ""));
        mainMenu.getMenuElements()[3] = (new MenuElement(3, "Удалить магнит", menuDeleteMagnet, ""));
        return mainMenu;
    }

    private Menu createMainBookMenu() {
        Menu mainMenu = new Menu(4);

        Menu menuSearchBook = new Menu(3);
        menuSearchBook.setMenuType(SEARCH_BOOK_MENU_INDEX);
        menuSearchBook.setMenuTitle("Вы находитесь в меню поиска книги.");
        menuSearchBook.getMenuElements()[1] = (new MenuElement(1, "Найти по номеру (id)", null, "Книга найдена."));
        menuSearchBook.getMenuElements()[2] = new MenuElement(2, "Найти по названию", null, "Книга найдена.");
        menuSearchBook.addDefaultElement(mainMenu);

        Menu menuDeleteBook = new Menu(3);
        menuDeleteBook.setMenuType(DELETE_BOOK_MENU_INDEX);
        menuDeleteBook.setMenuTitle("Вы находитесь в меню удаления книги.");
        menuDeleteBook.getMenuElements()[1] = (new MenuElement(1, "Удалить книгу по номеру (id)", null, "Книга удалена."));
        menuDeleteBook.getMenuElements()[2] = new MenuElement(2, "Удалить книгу по названию", null, "Книга удалена.");
        menuDeleteBook.addDefaultElement(mainMenu);

        Menu menuAddBook = new Menu(1);
        menuAddBook.setMenuTitle("Вы находитесь в меню добавления новой книги. ");
        menuAddBook.addDefaultElement(mainMenu);

        mainMenu.setMenuTitle("Вы находитесь в меню управления книгами.");
        mainMenu.setMenuType(MAIN_BOOK_MENU_INDEX);
        mainMenu.getMenuElements()[1] = new MenuElement(BOOK_ADD_MENU_ELEMENT_ID, "Добавить книгу", null,
                "Новая книга добавлена.");
        mainMenu.getMenuElements()[2] = (new MenuElement(2, "Найти книгу", menuSearchBook, ""));
        mainMenu.getMenuElements()[3] = (new MenuElement(3, "Удалить книгу", menuDeleteBook, ""));
        return mainMenu;
    }
}