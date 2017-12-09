package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Book {
    String id;
    String title;
    String author;

    public Book(String bookId, String bookAuthor, String bookTitle) {
        id = bookId;
        author = bookAuthor;
        title = bookTitle;
    }
}
