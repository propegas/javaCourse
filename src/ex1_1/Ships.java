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
    public boolean addShip(Ship ship) {

        if (!checkShipIntersection(ship)) {
            this.shipList.add(ship);
            return true;
        }

        return false;
    }

    private boolean checkShipIntersection(Ship newShip) {
        for (Ship ship : shipList) {
            List<Coords> shipCells = ship.getShipCells();
            for (Coords shipCoord : shipCells) {
                for (Coords newShipCoord : newShip.getShipCells()) {
                    if (shipCoord.equals(newShipCoord)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Ship addRandomShip(short maxSize) {
        Ship ship = new Ship(maxSize);
        return ship;
    }
}
