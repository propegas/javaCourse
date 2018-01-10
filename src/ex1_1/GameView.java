package ex1_1;

import java.util.Scanner;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class GameView {
    public String getNameFromUser(short id) {
        System.out.println("Введите имя для игрока " + id);
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            name = scanner.nextLine();
            if (!"".equals(name)) {
                break;
            }
        }

        return name;
    }
}
