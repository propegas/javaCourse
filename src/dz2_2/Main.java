package dz2_2;

/**
 * Created by macuser on 27.01.2018.
 */
public class Main {

    public static final int ARRAY_SIZE = 4;

    public static void main(String[] args) {
        String[][] strArray = new String[][]{
                {"123", "123", "123", "123"},
                {"123", "123", "123", "123"},
                {"123", "123", "123", "123"},
                {"123", "123", "123", "a"}};

        try {
            int sum = checkArray(strArray);
            System.out.println(String.format("Сумма чисел в массиве: %d", sum));
        } catch (MyArraySizeException e) {
            System.out.println("Неверная размерность массива.");
            System.out.println(String.format("Ожидаемая размерность: [%d][%d]", ARRAY_SIZE, ARRAY_SIZE));
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка преобразования в массиве.");
            System.out.println(String.format("Неdерный формат в ячейке [%d, %d]", e.getI(), e.getJ()));
            e.printStackTrace();
        }
    }

    private static int checkArray(String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        if (strArray.length != ARRAY_SIZE) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < strArray.length; i++) {
            String[] strings = strArray[i];

            if (strings.length != ARRAY_SIZE) {
                throw new MyArraySizeException();
            }

            for (int j = 0; j < strings.length; j++) {
                int transformedValue = transfromCellValue(i, j, strArray);
                System.out.println(transformedValue);
                sum += transformedValue;
            }
        }

        return sum;
    }

    private static int transfromCellValue(int i, int j, String[][] strArray) throws MyArrayDataException {
        String string = strArray[i][j];
        try {
            return Integer.valueOf(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new MyArrayDataException(i, j);
        }
    }

}
