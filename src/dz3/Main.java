package dz3;

import java.util.Scanner;

/**
 * Created by vgoryachev on 25.12.2017.
 * Package: dz3.
 */
public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String compWord = getRandomWordFromArray(words);
        boolean guessed = false;
        while (!guessed) {
            String guessedWord = getStringFromUser();
            guessed = isWordsEquals(guessedWord, compWord);
            if (guessed) {
                continue;
            }

            showPartOfGuessedWord(guessedWord, compWord);
        }
    }

    private static String getRandomWordFromArray(String[] words) {
        return null;
    }

    private static void showPartOfGuessedWord(String userWord, String compWord) {
        int maskedWordLength = 15;
        char maskChar = '#';
        for (int i = 0; i < userWord.length() || i < compWord.length(); i++) {
            char charAtCompWord = compWord.charAt(i);
            char charAtUserWord = userWord.charAt(i);
            printMaskOrChar(maskChar, charAtCompWord, charAtUserWord);
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
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
