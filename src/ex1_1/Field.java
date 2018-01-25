package ex1_1;

import java.util.List;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Field {
    public static char INJURED_SHIP_CHAR = 'X';
    public static char LIVE_SHIP_CHAR = '+';
    public static char DOT_CHAR = '.';
    public static char EMPTY_CHAR = ' ';

    private Ships ships;
    private int size;
    private char[][] cells;

    public Field(int tableSize) {
        this.size = tableSize;
        this.ships = new Ships();
        this.cells = new char[tableSize][tableSize];

        for (int i = 0; i < cells.length; i++) {
            char[] cell = cells[i];
            for (int j = 0; j < cell.length; j++) {
                cell[j] = EMPTY_CHAR;
            }
        }
    }

    public int getShipsCount() {
        return getShips().getShipList().size();
    }

    public Ships getShips() {
        return ships;
    }

    public void setShips(Ships ships) {
        this.ships = ships;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getCells() {
        return cells;
    }

    public boolean addShip(Ship ship) {
        if (!ships.checkShipIntersection(ship) && !checkShipFieldMargin(ship)) {
            ships.addShip(ship);
            for (Coordinates coord : ship.getShipCells()) {
                cells[coord.getX()][coord.getY()] = LIVE_SHIP_CHAR;
            }
            return true;
        }
        return false;
    }

    public void addRandomShip(int maxShipSize, int tableSize) {
        Ship ship = Ships.getRandomShip(maxShipSize, tableSize);
        addShip(ship);
    }

    private boolean checkShipFieldMargin(Ship ship) {
        List<Coordinates> shipCells = ship.getShipCells();
        for (Coordinates shipCoord : shipCells) {
            if (shipCoord.getX() >= size || shipCoord.getY() >= size ||
                    shipCoord.getX() < 0 || shipCoord.getY() < 0) {
                return true;
            }
        }
        return false;
    }

}
