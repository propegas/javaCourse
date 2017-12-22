package ex7.thingmanager;

import java.util.Scanner;

public class User {

    public User() {
// default
    }

    public int getThingIdFromUser() {
        return Integer.valueOf(getStringFromUser("Веедите ID вещи:"));
    }

    public Book getBookInfoFromUser() {
        String bookTitle = getStringFromUser("Введите название книги:");
        String bookAuthor = getStringFromUser("Введите автора книги:");
        int bookPrice = Integer.valueOf(getStringFromUser("Введите цену книги:"));
        return new Book(bookAuthor, bookTitle, bookPrice);
    }

    public Magnet getMagnetInfoFromUser() {
        String magnetCountry = getStringFromUser("Введите страну магнита:");
        int magnetPrice = Integer.valueOf(getStringFromUser("Введите цену магнита:"));
        return new Magnet(magnetCountry, magnetPrice);
    }

    private String getStringFromUser(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }

}