package ex1_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Ships implements ShipOperable {
    private List<Ship> shipList = new ArrayList<>();

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    @Override
    public void addShip(Ship ship) {

        this.shipList.add(ship);

    }

    public boolean checkShipIntersection(Ship newShip) {
        for (Ship ship : shipList) {
            if (ship == newShip) {
                continue;
            }

            List<Coords> shipCells = ship.getShipCells();
            for (Coords shipCoord : shipCells) {
                for (Coords newShipCoord : newShip.getShipCells()) {
                    if (shipCoord.equals(newShipCoord) || shipCoord.near(newShipCoord)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Ship getRandomShip(short maxSize, int tableSize) {
        Ship ship = new Ship(maxSize, tableSize);
        return ship;
    }
}
