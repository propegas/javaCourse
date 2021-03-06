package dz3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by vgoryachev on 25.12.2017.
 * Package: dz3.
 */
public class Main {
    public static void main(String[] args) {

        int e = new int[4][8].length;
        System.out.println(e);

        String s = "vavav = " + 2 + 2;
        System.out.println(s);
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String compWord = getRandomWordFromArray(words);
        boolean guessed = false;
        int attempt = 0;
        while (!guessed) {
            attempt++;
            String guessedWord = getStringFromUser();
            guessed = isWordsEquals(guessedWord, compWord);
            if (guessed) {
                continue;
            }
            showPartOfGuessedWord(guessedWord, compWord);
        }

        System.out.println("Вы угадали c " + attempt + " плопытки(ок)!");
    }

    private static String getRandomWordFromArray(String[] words) {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }

    private static void showPartOfGuessedWord(String userWord, String compWord) {
        int maskedWordLength = 15;
        char maskChar = '#';
        System.out.println("Вы угадали буквы: ");
        int i;
        for (i = 0; i < userWord.length() && i < compWord.length(); i++) {
            char charAtCompWord = compWord.charAt(i);
            char charAtUserWord = userWord.charAt(i);
            printMaskOrChar(maskChar, charAtCompWord, charAtUserWord);
        }

        int remainChars = maskedWordLength - i;
        printRemainMask(maskChar, remainChars);
        System.out.println();
    }

    private static void printRemainMask(char maskChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(maskChar);
        }
    }

    private static void printMaskOrChar(char maskChar, char charAtCompWord, char charAtUserWord) {
        if (charAtCompWord == charAtUserWord) {
            System.out.print(charAtCompWord);
        } else {
            System.out.print(maskChar);
        }
    }

    private static boolean isWordsEquals(String guessedWord, String compWord) {

        if (compWord.equals(guessedWord)) {
            return true;
        }
        return false;
    }

    private static String getStringFromUser() {
        System.out.println("Введите слово: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
