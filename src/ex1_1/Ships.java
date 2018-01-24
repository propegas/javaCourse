package ex1_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Ships {
    private List<Ship> shipList = new ArrayList<>();

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    public void addShip(Ship ship) {

        this.shipList.add(ship);

    }

    public boolean checkShipIntersection(Ship newShip) {
        for (Ship ship : shipList) {
            if (ship == newShip) {
                continue;
            }

            if (ship.isIntersectWith(newShip)) {
                return true;
            }
        }
        return false;
    }

    public static Ship getRandomShip(int maxSize, int tableSize) {
        Ship ship = new Ship(maxSize, tableSize);
        return ship;
    }
}
