package dz2_2;

/**
 * Created by macuser on 27.01.2018.
 */
public class MyArrayDataException extends Throwable {

    private final int i;
    private final int j;

    public MyArrayDataException(int i, int j) {

        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
