package ex1_1;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Player {
    private String name;
    private short id;
    private boolean isComp = false;

    public Player(String name, short id, boolean isComp) {
        this.name = name;
        this.id = id;
        this.isComp = isComp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public boolean isComp() {
        return isComp;
    }

    public void setComp(boolean comp) {
        isComp = comp;
    }
}
