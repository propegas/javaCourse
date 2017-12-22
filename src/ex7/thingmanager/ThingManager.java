package ex7.thingmanager;

import java.util.ArrayList;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class ThingManager {

    private ArrayList<Thing> things = new ArrayList<>();

    public ThingManager() {
//        this.things = new ArrayList<>();
    }

    private void removeThingFromManager(Thing thing) {
        things.remove(thing);
    }

    public ArrayList<Thing> getThings() {
        return things;
    }

    public void addThing(Thing thing) {
        this.things.add(thing);
    }

    public void removeAllThings() {
        things.clear();
    }

    public void showAllThings() {
        for (Thing thing : things) {
            System.out.println(thing);
        }
    }

    public Thing findThingById(int id) {
        for (Thing thing : things) {
            if (thing.getId() == id) {
                return thing;
            }
        }
        return null;
    }

    public void removeThingById(int id) {
        Thing thing = findThingById(id);
        if (thing != null) {
            removeThingFromManager(thing);
        }
    }

}
