package ex1_1;

/**
 * Created by vgoryachev on 11.01.2018.
 * Package: ex1_1.
 */
public class Coordinates {

    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isNear(final Coordinates coords) {

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

        Coordinates coords = (Coordinates) o;

        if (x != coords.x) return false;
        return y == coords.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
