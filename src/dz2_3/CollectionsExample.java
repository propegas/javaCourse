package dz2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macuser on 31.01.2018.
 */
public class CollectionsExample {

    public static final int INITIAL_CAPACITY = 20;

    public static void main(String[] args) {
        List<String> words = init();
        Map<String, Integer> wordsUnique = findUniqueWords(words);
        showUniqueWords(wordsUnique);
    }

    private static void showUniqueWords(Map<String, Integer> wordsUnique) {
        for (Map.Entry<String, Integer> stringIntegerEntry : wordsUnique.entrySet()) {
            System.out.println(String.format("Слово \t'%s' \t встречается \t%d \tраз(а).", stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
        }
    }

    private static Map<String, Integer> findUniqueWords(List<String> words) {

        Map<String, Integer> wordsUnique = new HashMap<>(INITIAL_CAPACITY);

        for (String word : words) {
            int count = getCountVyWordInList(word, words);
            wordsUnique.put(word, count);
        }

        return wordsUnique;
    }

    private static int getCountVyWordInList(String wordToFind, List<String> words) {
        int count = 0;

        for (String word : words) {
            if (word.equals(wordToFind)) {
                count++;
            }
        }

        return count;
    }

    private static List<String> init() {
        List<String> words = new ArrayList<>(INITIAL_CAPACITY);
        words.add("Аня");
        words.add("Ваня");
        words.add("Саша");
        words.add("Леша");
        words.add("Миша");
        words.add("Маша");
        words.add("Саша");
        words.add("Коля");
        words.add("Оля");
        words.add("Леша");
        words.add("Саша");
        words.add("Мила");
        words.add("Аня");
        words.add("Аня");
        words.add("Аня");
        words.add("Аня");

        return words;
    }
}
