package ex7.thingmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Book extends Thing {

    private String title;
    private String author;

    public Book() {
        // default;
    }

    public Book(String bookAuthor, String bookTitle, int price) {
        super(price);
        this.author = bookAuthor;
        this.title = bookTitle;
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

    @Override
    public String toString() {
        return "id: " + super.getId() + "\tКнига " +
                "'" + title + '\'' +
                ", " + author;
    }

}
