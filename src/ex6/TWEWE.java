package ex6;

/**
 * Created by macuser on 12.12.2017.
 */
public class TWEWE {
    private static TWEWE ourInstance = new TWEWE();

    public static TWEWE getInstance() {
        return ourInstance;
    }

    private TWEWE() {
    }
}
