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
    private short status;
    private short size;
    private Coords startCoord;
    private Coords endCoord;

    public Ship(short size, Coords startCoord, Coords endCoord) {
        this.size = size;
        this.startCoord = startCoord;
        this.endCoord = endCoord;
        this.status = ALIVE;
    }

    public Ship(short maxShipSize) {
        // default random
        Random random = new Random();
        this.size = (short) random.nextInt(maxShipSize);
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public Coords getStartCoord() {
        return startCoord;
    }

    public void setStartCoord(Coords startCoord) {
        this.startCoord = startCoord;
    }

    public Coords getEndCoord() {
        return endCoord;
    }

    public void setEndCoord(Coords endCoord) {
        this.endCoord = endCoord;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public List<Coords> getShipCells() {
        List<Coords> shipCoords = new ArrayList<>(size);
        if (startCoord.getX() == endCoord.getX()) {
            short minY, maxY;
            if (startCoord.getY() < endCoord.getY()) {
                minY = startCoord.getY();
                maxY = endCoord.getY();
            } else {
                minY = endCoord.getY();
                maxY = startCoord.getY();
            }

            for (short i = minY; i < maxY; i++) {
                shipCoords.add(new Coords(startCoord.getX(), i));
            }

        } else if (startCoord.getY() == endCoord.getY()) {
            short minX, maxX;
            if (startCoord.getX() < endCoord.getX()) {
                minX = startCoord.getX();
                maxX = endCoord.getX();
            } else {
                minX = endCoord.getX();
                maxX = startCoord.getX();
            }

            for (short i = minX; i < maxX; i++) {
                shipCoords.add(new Coords(i, startCoord.getY()));
            }

        }
        return shipCoords;
    }
}
