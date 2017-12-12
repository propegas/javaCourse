import java.util.Arrays;
import java.util.Objects;

/**
 * Created by vgoryachev on 30.11.2017.
 * Package: PACKAGE_NAME.
 */
public class SeaBattle {
    public static void main(String[] args) throws InterruptedException {

        char[][] table = init();

        short[] players = {1, 2};

        char[] playerChars = {'X', '0'};

        String[] winLines = {"[X, X, X]", "[0, 0, 0]"};

        boolean end = false;
        short moveNumber = 0;

        while (!end) {
            moveNumber++;
            int playerNum = moveNumber % 2 + 1;
            System.out.printf("Ход игрока %d %n", playerNum);
            int[] moveCoords = nextMove(table);
            saveMove(table, playerChars[playerNum - 1], moveCoords);
            printTable(table);
            end = isGameOver(table, winLines, moveNumber);
            Thread.sleep(1000);
        }

        System.out.println("Game over!");
    }

    private static void saveMove(char[][] table, char moveChar, int[] moveCoords) {
        int x = moveCoords[0];
        int y = moveCoords[1];
        System.out.printf("Set %s to X: %s, Y: %s %n", moveChar, x, y);
        table[x][y] = moveChar;
    }

    private static boolean isGameOver(char[][] table, String[] winLines, short moveNumber) {
        if (moveNumber >= 9)
            return true;
        if (isLineFull(table, winLines))
            return true;
        if (isColumnFull(table, winLines))
            return true;
        return isDiagFull(table, winLines);
    }

    private static boolean isDiagFull(char[][] table, String[] winLines) {
        return false;
    }

    private static boolean isColumnFull(char[][] table, String[] winLines) {
        for (int i = 0; i < 3; i++) {
            char[] column = new char[3];
            for (int j = 0; j < 3; j++) {
//                invert
                column[j] = table[j][i];
            }

            if (checkWinLine(winLines, column)) return true;

        }
        return false;
    }

    private static boolean checkWinLine(String[] winLines, char[] column) {
        if (Objects.equals(Arrays.toString(column), winLines[0]))
            return true;
        if (Objects.equals(Arrays.toString(column), winLines[1]))
            return true;
        return false;
    }

    private static boolean isLineFull(char[][] table, String[] winLines) {
        for (int i = 0; i < 3; i++) {
            char[] chars = table[i];

            if (checkWinLine(winLines, chars)) return true;
        }
        return false;
    }

    private static void printTable(char[][] table) {
        for (int i = 0; i < 3; i++) {
            char[] chars = table[i];
            for (int j = 0; j < 3; j++) {
                char aChar = chars[j];
                System.out.printf("%s ", aChar);
            }
            System.out.println();
        }
    }

    private static int[] nextMove(char[][] table) {

        int x = getRandomCoord(0, 2);
        int y = getRandomCoord(0, 2);
        System.out.printf("X: %s, Y: %s", x, y);
        System.out.println();

        int[] coords = {x, y};
        if (!isMoveCorrect(coords, table)) {
            coords = nextMove(table);
        }
        return coords;
    }

    private static boolean isMoveCorrect(int[] coords, char[][] table) {
        return table[coords[0]][coords[1]] == '.';
    }

    private static int getRandomCoord(int min, int max) {
        int randomCoord = min + (int) (Math.random() * (max + 1));
        return randomCoord;
    }

    private static char[][] init() {
        System.out.println("Инициализация поля...");
        char[][] table = {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
        printTable(table);
        return table;
    }
}
