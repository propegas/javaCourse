package ex7.thingmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Magnet extends Thing {

    private String country;

    public Magnet() {
        //default
    }

    public Magnet(String country) {
        this.country = country;
    }

    public Magnet(String magnetCountry, int price) {
        super(price);
        this.country = magnetCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id: " + super.getId() + "\tМагнит из " +
                country;
    }

}
