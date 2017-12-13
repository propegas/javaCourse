package ex7.bookmanager;

/**
 * Created by vgoryachev on 13.12.2017.
 * Package: ex7.bookmanager.
 */
public class MagnetManager extends ThingManager {

    private static MagnetManager ourInstance = new MagnetManager();

    private MagnetManager() {
        //singleton
    }

    public static MagnetManager getInstance() {
        return ourInstance;
    }

    public void prepareSearchBook(MenuElement menuElement) {
        Book findBook = null;
        if (menuElement.getId() == 1) {
            findBook = (Book) getThingById();
        } else if (menuElement.getId() == 2) {
            findBook = getBookByTitle();
        }

        if (findBook != null) {
            System.out.println(menuElement.getResult());
            System.out.printf("%s%n%n", findBook);
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    @Override
    public Thing getThingById() {
        int id = Integer.parseInt(getStringFromUser("Введите ID книги:"));
        return findThingById(id);
    }

    private Book getBookByTitle() {
        Book findBook;
        String bookTitleToSearch = getBookTitleToSearchFromUser();
        findBook = findBookByTitle(bookTitleToSearch);
        return findBook;
    }

    private String getBookTitleToSearchFromUser() {
        return getStringFromUser("Введите название книги:");
    }

    private Book findBookByTitle(String bookTitleToSearch) {
        for (Thing thing : getThings()) {
            if (((Book) thing).getTitle().equalsIgnoreCase(bookTitleToSearch)) {
                return (Book) thing;
            }
        }
        return null;
    }

    public void prepareDeleteBook(MenuElement menuElement) {
        Book findBook = null;
        if (menuElement.getId() == 1) {
            findBook = (Book) getThingById();
        } else if (menuElement.getId() == 2) {
            findBook = getBookByTitle();
        }

        if (findBook != null) {
            System.out.printf("%s%n%n", findBook);
            removeThingFromManager(findBook);
            System.out.println(menuElement.getResult());
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    public void prepareManageMagnet(MenuElement menuElement) {
        Book bookInfoFromUser;
        if (menuElement.getId() == MenuBuilder.MAGNET_ADD_MENU_ELEMENT_ID) {
            bookInfoFromUser = getBookInfoFromUser();
            addBookToManager(bookInfoFromUser);
            System.out.println(menuElement.getResult());
        }

    }

    private void addBookToManager(Book bookInfoFromUser) {
        getThings().add(bookInfoFromUser);
        increaseTotal();
    }
}
