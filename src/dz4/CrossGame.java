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
            int playerNum = (MOVE_NUMBER + firstPlayer) % 2;
            System.out.printf("Ход игрока %d %n", playerNum);
            nextMove(playerNum);
            printTable();
            end = isGameOver(playerNum);
        }

        System.out.println("Игра окончена.");

    }

    private static boolean isGameOver(int playerNum) {
        if (MOVE_NUMBER >= TABLE_SIZE * TABLE_SIZE)
            return true;

        int[] maxLineRow = findMaxLineByType(0, true);
        System.out.println("Максимальная непрерывная строка: " + maxLineRow[2] + " элемента");
        int[] maxLineColumn = findMaxLineByType(1, true);
        System.out.println("Максимальная непрерывная колонка: " + maxLineColumn[2] + " элемента");

        if (maxLineRow[2] == WIN_LINE || maxLineColumn[2] == WIN_LINE) {
            System.out.println("Победил игрок " + playerNum);
            return true;
        }

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
        int checkX, checkY;

        int[] maxLineRow = findMaxLineByType(0, false);
        System.out.println("Максимальная непрерывная открытая строка: " + maxLineRow[2] + " элемента");
        int[] maxLineColumn = findMaxLineByType(1, false);
        System.out.println("Максимальная непрерывная открытая колонка: " + maxLineColumn[2] + " элемента");
        int[] maxLineDiag1 = findMaxLineByType(2, false);
        System.out.println("Максимальная непрерывная открытая диагональ1: " + maxLineColumn[2] + " элемента");
        int[] maxLineDiag2 = findMaxLineByType(3, false);
        System.out.println("Максимальная непрерывная открытая диагональ2: " + maxLineColumn[2] + " элемента");

        int[] moveFromLine = getNextMoveFromMaxLines(maxLineRow, maxLineColumn, maxLineDiag1, maxLineDiag2);
        if (moveFromLine != null) {
            return moveFromLine;
        }

        // default random
        checkX = random.nextInt(TABLE_SIZE);
        checkY = random.nextInt(TABLE_SIZE);
        return new int[]{checkX, checkY};
    }

    private static int[] getNextMoveFromMaxLines(int[] maxLineRow, int[] maxLineColumn, int[] maxLineDiag1, int[] maxLineDiag2) {
        if (maxLineColumn[2] > 0 && maxLineColumn[2] >= maxLineRow[2] && maxLineColumn[2] >= maxLineDiag1[2] && maxLineColumn[2] >= maxLineDiag2[2]) {
            int[] moveFromLineColumn = checkLineForCorrectMove(maxLineColumn, 1);
            if (moveFromLineColumn != null) {
                System.out.println("Блокируем колонку...");
                return moveFromLineColumn;
            }
        }
        if (maxLineRow[2] > 0 && maxLineRow[2] >= maxLineColumn[2]) {
            int[] moveFromLineRow = checkLineForCorrectMove(maxLineRow, 0);
            if (moveFromLineRow != null) {
                System.out.println("Блокируем строку...");
                return moveFromLineRow;
            }
        }
        return null;
    }

    private static int[] checkLineForCorrectMove(int[] maxLine, int lineType) {
        int checkX, checkY;

        // element - 1
        if (lineType == 0) {
            checkX = maxLine[0];
            checkY = maxLine[1] - 1;
        } else {
            checkY = maxLine[1];
            checkX = maxLine[0] - 1;
        }
        if (isMoveCorrect(checkX, checkY)) {
            return new int[]{checkX, checkY};
        }

        // element + 1
        if (lineType == 0) {
            checkX = maxLine[0];
            checkY = maxLine[1] + maxLine[2];
        } else {
            checkY = maxLine[1];
            checkX = maxLine[0] + maxLine[2];
        }
        if (isMoveCorrect(checkX, checkY)) {
            return new int[]{checkX, checkY};
        }

        return null;
    }

    private static int[] findMaxLineByType(int lineType, boolean checkWinLine) {
        // index 0 - begin of line (X)
        // index 1 - begin of line (Y)
        // index 2 - size of continious line
        int[] maxRow = new int[3];
        int[] maxLineX, maxLineO;
        for (int i = 0; i < TABLE_SIZE; i++) {
            maxLineX = findMaxLine(i, X_CHAR, lineType, checkWinLine);
            maxLineO = findMaxLine(i, O_CHAR, lineType, checkWinLine);

            // check Size
            if (maxLineO[2] > maxRow[2]) {
                maxRow = maxLineO;
            }
            if (maxLineX[2] > maxRow[2]) {
                maxRow = maxLineX;
            }

        }

        return maxRow;
    }

    // lineTypeFlag = 0 - check rows
    // lineTypeFlag = 1 - check columns
    private static int[] findMaxLine(int line, char checkChar, int lineTypeFlag, boolean checkWinLine) {
        // index 0 - begin of line (X)
        // index 1 - begin of line (Y)
        // index 2 - size of continious line

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

                if (checkWinLine || checkLineSurroundByEmptyCell(tempLineStart, tempLineSize, lineTypeFlag, line)) {
                    if (tempLineSize > lineSize) {
                        lineSize = tempLineSize;
                        lineStart = tempLineStart;
                    }
                }
            }
        }

        if (lineTypeFlag == 0) {
            return new int[]{line, lineStart, lineSize};
        } else {
            return new int[]{lineStart, line, lineSize};

        }
    }

    private static boolean checkLineSurroundByEmptyCell(int lineStart, int lineSize, int lineTypeFlag, int line) {
        if (lineTypeFlag == 0) {
            if (checkCoordsIsCorrect(line, lineStart - 1) && table[line][lineStart - 1] == EMPTY_CHAR) {
                return true;
            }
            if (checkCoordsIsCorrect(line, lineStart + lineSize) && table[line][lineStart + lineSize] == EMPTY_CHAR) {
                return true;
            }
            return false;
        } else {
            if (checkCoordsIsCorrect(lineStart - 1, line) && table[lineStart - 1][line] == EMPTY_CHAR) {
                return true;
            }
            if (checkCoordsIsCorrect(lineStart + lineSize, line) && table[lineStart + lineSize][line] == EMPTY_CHAR) {
                return true;
            }
            return false;
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
        return x < TABLE_SIZE && y < TABLE_SIZE && x >= 0 && y >= 0;
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
