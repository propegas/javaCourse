package ex7.bookmanager;

public class MenuBuilder {
    public MenuBuilder() {
    }

    public void createMainMenu(Menu mainMenu) {
        Menu mainBookMenu = createMainBookMenu();
        mainBookMenu.addDefaultElement(mainMenu);

        mainMenu.menuTitle = "Вы находитесь в меню управления вещами.";
        mainMenu.menuType = ThingManager.MAIN_MENU_INDEX;
        mainMenu.menuElements[0] = new MenuElement(ThingManager.SHOW_ALL_MENU_ELEMENT_ID, "Список вещей", null,
                "Новая книга добавлена.");
        mainMenu.menuElements[1] = (new MenuElement(1, "Управление книгами", mainBookMenu, ""));
        mainMenu.menuElements[2] = (new MenuElement(ThingManager.DELETE_ALL_MENU_ELEMENT_ID, "Удалить все вещи", null, "Хранилище очищено."));
    }

    Menu createMainBookMenu() {
        Menu mainMenu = new Menu(4);

        Menu menuSearchBook = new Menu(3);
        menuSearchBook.menuType = ThingManager.SEARCH_BOOK_MENU_INDEX;
        menuSearchBook.menuTitle = "Вы находитесь в меню поиска книги.";
        menuSearchBook.menuElements[1] = (new MenuElement(1, "Найти по номеру (id)", null, "Книга найдена."));
        menuSearchBook.menuElements[2] = new MenuElement(2, "Найти по названию", null, "Книга найдена.");
        menuSearchBook.addDefaultElement(mainMenu);

        Menu menuDeleteBook = new Menu(3);
        menuDeleteBook.menuType = ThingManager.DELETE_BOOK_MENU_INDEX;
        menuDeleteBook.menuTitle = "Вы находитесь в меню удаления книги.";
        menuDeleteBook.menuElements[1] = (new MenuElement(1, "Удалить книгу по номеру (id)", null, "Книга удалена."));
        menuDeleteBook.menuElements[2] = new MenuElement(2, "Удалить книгу по названию", null, "Книга удалена.");
        menuDeleteBook.addDefaultElement(mainMenu);

        Menu menuAddBook = new Menu(1);
        menuAddBook.menuTitle = "Вы находитесь в меню добавления новой книги. ";
        menuAddBook.addDefaultElement(mainMenu);

        mainMenu.menuTitle = "Вы находитесь в меню управления книгами.";
        mainMenu.menuType = ThingManager.MAIN_BOOK_MENU_INDEX;
        mainMenu.menuElements[1] = new MenuElement(ThingManager.BOOK_ADD_MENU_ELEMENT_ID, "Добавить книгу", null,
                "Новая книга добавлена.");
        mainMenu.menuElements[2] = (new MenuElement(2, "Найти книгу", menuSearchBook, ""));
        mainMenu.menuElements[3] = (new MenuElement(3, "Удалить книгу", menuDeleteBook, ""));
        return mainMenu;
    }
}