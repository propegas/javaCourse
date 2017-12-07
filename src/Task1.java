import java.util.Locale;
import java.util.Scanner;

/**
 * Created by vgoryachev on 01.12.2017.
 * Package: PACKAGE_NAME.
 */
public class Task1 {
    public static void main(String[] args) {

        System.out.println(String.format(
                Locale.ROOT, "%.4f", Double.parseDouble("21.0000")));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число:");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите число:");
        int b = scanner.nextInt();
    }
}
