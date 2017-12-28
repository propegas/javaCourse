package ex7.thingmanager;

/**
 * Created by vgoryachev on 25.12.2017.
 * Package: ex7.thingmanager.
 */
public interface Storable {
    Thing getById(int id);
    void save(Thing thing);
}
