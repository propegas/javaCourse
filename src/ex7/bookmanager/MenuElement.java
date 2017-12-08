package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class MenuElement {
    int id;
    String title;
    Menu menu;

    public MenuElement(int menuElementId, String menuElementTitle, Menu menu) {
        this.id = menuElementId;
        this.title = menuElementTitle;
        this.menu = menu;
    }
}
