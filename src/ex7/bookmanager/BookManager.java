package ex7.bookmanager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class BookManager {
    public static final int MAIN_MENU_INDEX = 0;
    public static final int DELETE_BOOK_MENU_INDEX = 1;
    public static final int SEARCH_BOOK_MENU_INDEX = 2;
    static int totalBooks;
    Menu currentMenu;
    ArrayList<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    private static void decreaseTotal() {
        totalBooks--;
    }

    private static void increaseTotal() {
        totalBooks++;
    }

    public void showMenu() {
        Menu mainMenu = currentMenu;
        mainMenu.showMenu();
    }

    public String getUserChoice() {
        System.out.printf("В менеджере зарегистрировано %d книг %n", totalBooks);
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
                    prepareAddBook(currentMenu.menuElements[(userChoice)]);
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

    private void prepareDeleteBook(MenuElement menuElement) {
        Book findBook = null;
        if (menuElement.id == 1) {
            findBook = getBookById();
        } else if (menuElement.id == 2) {
            findBook = getBookByTitle();
        }

        if (findBook != null) {
            System.out.printf("Автор: %s %nНазвание: %s%n%n", findBook.getAuthor(), findBook.getTitle());
            removeBookFromManager(findBook);
            System.out.println(menuElement.result);
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    private void removeBookFromManager(Book findBook) {
        books.remove(findBook);
        decreaseTotal();
    }

    private void prepareSearchBook(MenuElement menuElement) {
        Book findBook = null;
        if (menuElement.id == 1) {
            findBook = getBookById();
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

    private Book getBookById() {
        Book findBook;
        String bookIdToSearch = getBookIdToSearchFromUser();
        findBook = findBookById(bookIdToSearch);
        return findBook;
    }

    private Book findBookByTitle(String bookTitleToSearch) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(bookTitleToSearch.toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    private String getBookTitleToSearchFromUser() {
        String title = getStringFromUser("Введите название книги:");
        return title;
    }

    private Book findBookById(String bookIdToSearch) {
        for (Book book : books) {
            if (bookIdToSearch.toLowerCase().equals(book.getId().toLowerCase())) {
                return book;
            }
        }
        return null;
    }

    private String getBookIdToSearchFromUser() {
        String bookId = getStringFromUser("Веедите ID книги:");
        return bookId;
    }

    private void prepareAddBook(MenuElement menuElement) {
        Book bookInfoFromUser;
        if (menuElement.id == 0) {
            bookInfoFromUser = getBookInfoFromUser();
            addBookToManager(bookInfoFromUser);
            System.out.println(menuElement.result);
        }

    }

    private void addBookToManager(Book bookInfoFromUser) {
        books.add(bookInfoFromUser);
        increaseTotal();
    }

    private Book getBookInfoFromUser() {
        String bookTitle = getStringFromUser("Веедите название книги:");
        String bookAuthor = getStringFromUser("Веедите автора книги:");
        String bookId = getStringFromUser("Веедите ID книги:");
        Book newBook = new Book(bookId, bookAuthor, bookTitle);
        return newBook;
    }

    private String getStringFromUser(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        String stringInfo = scanner.nextLine();
        return stringInfo;
    }

    public void createMainMenu(Menu mainMenu) {
        mainMenu.menuTitle = "Вы находитесь в главном меню.";
        mainMenu.menuType = MAIN_MENU_INDEX;

        Menu menuSearchBook = new Menu(3);
        menuSearchBook.menuType = SEARCH_BOOK_MENU_INDEX;
        menuSearchBook.menuTitle = "Вы находитесь в меню поиска книги.";
        menuSearchBook.menuElements[1] = (new MenuElement(1, "Найти по номеру (id)", null, "Книга найдена."));
        menuSearchBook.menuElements[2] = new MenuElement(2, "Найти по названию", null, "Книга найдена.");
        menuSearchBook.addDefaultElement(mainMenu);

        Menu menuDeleteBook = new Menu(3);
        menuDeleteBook.menuType = DELETE_BOOK_MENU_INDEX;
        menuDeleteBook.menuTitle = "Вы находитесь в меню удаления книги.";
        menuDeleteBook.menuElements[1] = (new MenuElement(1, "Удалить книгу по номеру (id)", null, "Книга удалена."));
        menuDeleteBook.menuElements[2] = new MenuElement(2, "Удалить книгу по названию", null, "Книга удалена.");
        menuDeleteBook.addDefaultElement(mainMenu);

        Menu menuAddBook = new Menu(1);
        menuAddBook.menuTitle = "Вы находитесь в меню добавления новой книги. ";
        menuAddBook.addDefaultElement(mainMenu);

        mainMenu.menuElements[0] = new MenuElement(0, "Добавить книгу", null,
                "Новая книга добавлена в менеджер книг.");
        mainMenu.menuElements[1] = (new MenuElement(1, "Найти книгу", menuSearchBook, ""));
        mainMenu.menuElements[2] = (new MenuElement(2, "Удалить книгу", menuDeleteBook, ""));
    }
}
