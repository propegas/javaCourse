package ex1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Ship {
    private static final short ALIVE = 0;
    private int status;
    private int size;
    private Coordinates startCoord;
    private Coordinates endCoord;

    public Ship(int size, Coordinates startCoord, Coordinates endCoord) {
        this.size = size;
        this.startCoord = startCoord;
        this.endCoord = endCoord;
        this.status = ALIVE;
    }

    public Ship(int maxShipSize, int tableSize) {
        // default random
        Random random = new Random();
        this.size = random.nextInt(maxShipSize) + 1;

        boolean isHorizontal = random.nextBoolean();
        int x = random.nextInt(tableSize);
        int y = random.nextInt(tableSize);
        startCoord = new Coordinates(x, y);
        if (isHorizontal) {
            endCoord = new Coordinates((x + size), y);
        } else {
            endCoord = new Coordinates(x, (y + size));
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Coordinates getStartCoord() {
        return startCoord;
    }

    public void setStartCoord(Coordinates startCoord) {
        this.startCoord = startCoord;
    }

    public Coordinates getEndCoord() {
        return endCoord;
    }

    public void setEndCoord(Coordinates endCoord) {
        this.endCoord = endCoord;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public List<Coordinates> getShipCells() {
        List<Coordinates> shipCoords = new ArrayList<>(size);
        if (isHorizontal()) {
            int minY, maxY;
            if (isUpToDown()) {
                minY = startCoord.getY();
                maxY = endCoord.getY();
            } else {
                minY = endCoord.getY();
                maxY = startCoord.getY();
            }

            for (int i = minY; i < maxY; i++) {
                shipCoords.add(new Coordinates(startCoord.getX(), i));
            }

        } else if (isVertical()) {
            int minX, maxX;
            if (isLeftToRight()) {
                minX = startCoord.getX();
                maxX = endCoord.getX();
            } else {
                minX = endCoord.getX();
                maxX = startCoord.getX();
            }

            for (int i = minX; i < maxX; i++) {
                shipCoords.add(new Coordinates(i, startCoord.getY()));
            }

        }
        return shipCoords;
    }

    private boolean isLeftToRight() {
        return startCoord.getX() < endCoord.getX();
    }

    private boolean isVertical() {
        return startCoord.getY() == endCoord.getY();
    }

    private boolean isUpToDown() {
        return startCoord.getY() < endCoord.getY();
    }

    private boolean isHorizontal() {
        return startCoord.getX() == endCoord.getX();
    }

    public boolean isIntersectWith(Ship newShip) {
        List<Coordinates> shipCells = this.getShipCells();
        for (Coordinates shipCoord : shipCells) {
            for (Coordinates newShipCoord : newShip.getShipCells()) {
                if (shipCoord.equals(newShipCoord) || shipCoord.isNear(newShipCoord)) {
                    return true;
                }
            }
        }
        return false;
    }
}
