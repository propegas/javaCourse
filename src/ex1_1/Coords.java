package ex1_1;

/**
 * Created by vgoryachev on 11.01.2018.
 * Package: ex1_1.
 */
public class Coords {

    private short x, y;

    public Coords(short x, short y) {
        this.x = x;
        this.y = y;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public boolean near(Coords o) {

        Coords coords = (Coords) o;

        if (x == coords.x + 1 || x == coords.x - 1) {
            return (y == coords.y || y == coords.y - 1 || y == coords.y + 1);
        }
        if (y == coords.y + 1 || y == coords.y - 1) {
            return (x == coords.x || x == coords.x - 1 || x == coords.x + 1);
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coords coords = (Coords) o;

        if (x != coords.x) return false;
        return y == coords.y;
    }

    @Override
    public int hashCode() {
        int result = (int) x;
        result = 31 * result + (int) y;
        return result;
    }
}
