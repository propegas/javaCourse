package ex6;

import java.util.Scanner;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Player {
    int betAmount;
    int horseNum;

    public void setBetFromScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На какую лошадь ставка (номер):");
        this.horseNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Размер ставки ($):");
        this.betAmount = scanner.nextInt();
    }
}
