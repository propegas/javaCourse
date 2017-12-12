package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Book extends Thing {

    private String title;
    private String author;

    public Book(String bookId, String bookAuthor, String bookTitle) {
        super.setId(bookId);
        author = bookAuthor;
        title = bookTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
