package ex1_1;

import static ex1_1.SeaBattle.TABLE_SIZE;

/**
 * Created by vgoryachev on 10.01.2018.
 * Package: ex1_1.
 */
public class Player {

    private Field field;
    private String name;
    private short id;
    private boolean isComp;
    private int maxShipsCount;

    public Player(String name, short id, boolean isComp, int maxShipsCount) {
        this.name = name;
        this.id = id;
        this.isComp = isComp;
        this.maxShipsCount = maxShipsCount;
        this.field = new Field(TABLE_SIZE);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
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

    public boolean isNotAllShipsCreated() {
        return (field.getShipsCount() < maxShipsCount);
    }

    public int getMaxShipsCount() {
        return maxShipsCount;
    }
}
