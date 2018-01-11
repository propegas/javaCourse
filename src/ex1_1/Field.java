package ex1_1;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Field {
    public static char X_CHAR = 'X';
    public static char SHIP_CHAR = '+';
    public static char DOT_CHAR = '.';
    public static char EMPTY_CHAR = ' ';

    private Ships ships;
    private int size;
    private char[][] cells;

    public Field(int tableSize) {
        this.size = tableSize;
        this.cells = new char[tableSize][tableSize];

        for (int i = 0; i < cells.length; i++) {
            char[] cell = cells[i];
            for (int j = 0; j < cell.length; j++) {
                cell[j] = EMPTY_CHAR;
            }
        }
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
        if (ships.addShip(ship)) {
            for (Coords coord : ship.getShipCells()) {
                cells[coord.getX()][coord.getY()] = SHIP_CHAR;
            }
            return true;
        }
        return false;
    }

    public void addRandomShip(short maxShipSize) {
        Ship ship = this.ships.getRandomShip(maxShipSize);
        addShip(ship);
    }
}
