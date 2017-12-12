package ex6;

import java.util.Scanner;

/**
 * Created by vgoryachev on 06.12.2017.
 * Package: ex6.
 */
public class Player {
    private int betAmount;
    private int horseNum;

    public Player() {
        //default
    }

    public void setBetFromScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На какую лошадь ставка (номер):");
        this.horseNum = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Размер ставки ($):");
        this.betAmount = scanner.nextInt();
    }

    public float getPrize(Horse winnerHorse) {
        return (float) (this.betAmount * winnerHorse.getBetRate());
    }

    public int getHorseNum() {
        return horseNum;
    }
}