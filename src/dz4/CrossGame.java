package dz4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by vgoryachev on 28.12.2017.
 * Package: dz4.
 */
public class CrossGame {
    public static int TABLE_SIZE = 5;
    public static char X_CHAR = 'X';
    public static char O_CHAR = 'O';
    public static char[] MOVE_QUEUE = {X_CHAR, O_CHAR};
    public static char EMPTY_CHAR = '.';
    public static int WIN_LINE = 4;
    public static int MOVE_NUMBER;
    public static char[][] table = new char[TABLE_SIZE][TABLE_SIZE];
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static String HUMAN_MOVE_TEXT = "Ваш ход:";
    public static String COMP_MOVE_TEXT = "Ход компьютера:";

    public static void main(String[] args) {
        initTable();
        printTable();

        int firstPlayer = random.nextInt(2);
        boolean end = false;

        while (!end) {
            MOVE_NUMBER++;
            int playerNum = MOVE_NUMBER % 2 + firstPlayer;
            System.out.printf("Ход игрока %d %n", playerNum);
            nextMove(playerNum);
            printTable();
            end = isGameOver();
        }

    }

    private static boolean isGameOver() {
        if (MOVE_NUMBER >= TABLE_SIZE * TABLE_SIZE)
            return true;

        return false;
    }

    private static void nextMove(int playerNum) {
        int[] nextMoveCoords;
        if (playerNum == 0) {
            nextMoveCoords = humanMove();
            System.out.printf("%s %s%n", HUMAN_MOVE_TEXT, Arrays.toString(nextMoveCoords));
        } else {
            nextMoveCoords = compMove();
            System.out.printf("%s %s%n", COMP_MOVE_TEXT, Arrays.toString(nextMoveCoords));
        }

        char nextMoveChar = MOVE_QUEUE[playerNum];
        table[nextMoveCoords[0]][nextMoveCoords[1]] = nextMoveChar;
    }

    private static int[] compMove() {
        return getBestNextMove();
    }

    private static int[] getBestNextMove() {
        int[] maxLine;
        int checkX, checkY;
        maxLine = findMaxRow();

        checkX = maxLine[0];
        checkY = maxLine[1] - 1;
        if (isMoveCorrect(checkX, checkY)) {
            return new int[]{checkX, checkY};
        }
        checkX = maxLine[0];
        checkY = maxLine[1] + maxLine[2] ;
        if (isMoveCorrect(checkX, checkY)) {
            return new int[]{checkX, checkY};
        }

        // default
        checkX = random.nextInt(TABLE_SIZE);
        checkY = random.nextInt(TABLE_SIZE);
        return new int[]{checkX, checkY};
    }

    private static int[] findMaxRow() {
        int[] maxRow = new int[3];
        int[] maxLineX, maxLineO;
        for (int i = 0; i < TABLE_SIZE; i++) {
            maxLineX = findMaxLine(i, X_CHAR, 0);
            maxLineO = findMaxLine(i, O_CHAR, 0);

            // check Size
            if (maxLineX[2] > maxRow[2]) {
                maxRow = maxLineX;
            }
            if (maxLineO[2] > maxRow[2]) {
                maxRow = maxLineO;
            }

        }

        return maxRow;
    }

    // lineTypeFlag = 0 - check rows
    // lineTypeFlag = 1 - check columns
    private static int[] findMaxLine(int line, char checkChar, int lineTypeFlag) {
        int lineStart = 0;
        int lineSize = 0;

        for (int i = 0; i < TABLE_SIZE; i++) {
            char startChar;
            startChar = getStartCharByLineType(line, lineTypeFlag, i);
            if (startChar == checkChar) {
                int tempLineStart = i;
                int tempLineSize = 1;
                for (int j = i + 1; j < TABLE_SIZE; j++) {
                    char nextChar;
                    nextChar = getStartCharByLineType(line, lineTypeFlag, j);
                    if (nextChar == checkChar) {
                        tempLineSize++;
                    } else {
                        i += tempLineSize + 1;
                        break;
                    }
                }

                if (tempLineSize > lineSize && checkLineSurroundByEmptyCell(tempLineStart, tempLineSize, lineTypeFlag, line)) {
                    lineSize = tempLineSize;
                    lineStart = tempLineStart;
                }
            }
        }

        if (lineTypeFlag == 0) {
            return new int[]{line, lineStart, lineSize};
        } else {
            return new int[]{lineStart, line, lineSize};

        }
    }

    private static boolean checkLineSurroundByEmptyCell(int tempLineStart, int tempLineSize, int lineTypeFlag, int line) {
        if (lineTypeFlag == 0) {
            return (table[line][tempLineStart - 1] == EMPTY_CHAR || table[line][tempLineStart + tempLineSize + 1] == EMPTY_CHAR);
        } else {
            return (table[tempLineStart - 1][line] == EMPTY_CHAR || table[tempLineStart + tempLineSize + 1][line] == EMPTY_CHAR);
        }
    }

    private static char getStartCharByLineType(int line, int lineTypeFlag, int i) {
        char startChar;
        if (lineTypeFlag == 0) {
            startChar = table[line][i];
        } else {
            startChar = table[i][line];
        }
        return startChar;
    }

    private static int[] humanMove() {
        int x, y;
        int[] coords;
        do {
            System.out.println("Введите координаты хода (в формате [X Y]):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
            coords = new int[]{x, y};
        } while (!isMoveCorrect(coords));
        return coords;
    }

    private static boolean isMoveCorrect(int[] coords) {
        int x = coords[0];
        int y = coords[1];
        return isMoveCorrect(x, y);
    }

    private static boolean isMoveCorrect(int x, int y) {
        return checkCoordsIsCorrect(x, y) && table[x][y] == EMPTY_CHAR;
    }

    private static boolean checkCoordsIsCorrect(int x, int y) {
        return x < TABLE_SIZE && y < TABLE_SIZE && x > 0 && y > 0;
    }

    private static void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            char[] chars = table[i];
            for (int j = 0; j < TABLE_SIZE; j++) {
                char aChar = chars[j];
                System.out.printf("%s ", aChar);
            }
            System.out.println();
        }
    }

    private static void initTable() {
        System.out.println("Инициализация поля...");
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (int j = 0; j < TABLE_SIZE; j++) {
                table[i][j] = EMPTY_CHAR;
            }
        }
    }
}
