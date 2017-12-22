package dz2;

import java.util.Arrays;

/**
 * Created by vgoryachev on 21.12.2017.
 * Package: dz2.
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 9, 2, 8};
        shiftArray(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void shiftArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int currentElement = arr[0];
            int nextElement;
            int j = 1;
            while (j != 0) {
                if (j == arr.length) {
                    j = 0;
                }

                nextElement = arr[j];
                arr[j] = currentElement;
                currentElement = nextElement;
                if (j != 0) {
                    j++;
                }
            }
        }
    }

}
