package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Book extends Thing {

    private String title;
    private String author;

    public Book() {
        //default
    }

    public Book(String bookAuthor, String bookTitle) {
        //super.setId(bookId);
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

    @Override
    public String toString() {
        return "[" + super.getId() + "] " + "Книга {" +
                "'" + title + '\'' +
                ", " + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
