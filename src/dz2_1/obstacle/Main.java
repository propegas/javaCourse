package dz2_1.obstacle;

import dz2_1.Cat;
import dz2_1.Competitor;
import dz2_1.Dog;
import dz2_1.Human;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Team team = new Team(competitors);

        Obstacle[] obstacles = {new Cross(200), new Wall(2), new Wall(1), new Cross(660)};
        Course course = new Course(obstacles);

        course.doIt(team);

        team.showResults();
        team.showSuccesed();

    }
}
