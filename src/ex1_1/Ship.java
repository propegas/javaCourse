package ex1_1;

import java.util.List;
import java.util.Random;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Ship {
    private short status;
    private short size;
    private Coords startCoord;
    private Coords endCoord;

    public Ship(short size, Coords startCoord, Coords endCoord) {
        this.size = size;
        this.startCoord = startCoord;
        this.endCoord = endCoord;
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
        return null;
    }
}
