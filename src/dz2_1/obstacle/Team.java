package dz2_1.obstacle;

import dz2_1.Competitor;

/**
 * Created by macuser on 24.01.2018.
 */
public class Team {
    private Competitor[] competitors;

    public Team(Competitor[] competitors) {
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Competitor[] competitors) {
        this.competitors = competitors;
    }

    public void showSuccesed() {
        System.out.println();
        System.out.println("Успешно прошли дистанцию:");
        for (Competitor c : competitors) {
            if (c.isOnDistance()) {
                c.info();
            }
        }
    }

    public void showResults() {
        System.out.println();
        System.out.println("Результаты:");
        for (Competitor c : competitors) {
            c.fullInfo();
        }
    }
}
