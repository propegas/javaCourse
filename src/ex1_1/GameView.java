package ex1_1;

import java.util.Scanner;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class GameView implements GameViewable {

    private static final int A_CHAR = 65;

    @Override
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

    @Override
    public void showField(Player player) {
        showField(player, true);
    }

    @Override
    public void showField(Player player, boolean showShips) {

        System.out.println();
        System.out.println(player);

        Field field = player.getField();
        showHeader(field.getSize());

        for (int i = 0; i < field.getCells().length; i++) {
            char[] chars = field.getCells()[i];
            System.out.print(String.format("%d\t%c", i + 1, '|'));
            for (int j = 0; j < chars.length; j++) {
                if (!showShips && chars[j] != Field.LIVE_SHIP_CHAR);
                System.out.print(String.format("%c%c", chars[j], '|'));
            }
            System.out.println();
        }
    }

    @Override
    public void showNextPlayerMoveGreeting(Player currentPlayer) {
        System.out.println("Ход игрока " + currentPlayer);
    }

    private void showHeader(int size) {
        System.out.print(String.format(" \t "));
        for (int i = 0; i < size; i++) {
            System.out.print(String.format("%c ", A_CHAR + i));
        }
        System.out.println();
    }
}
