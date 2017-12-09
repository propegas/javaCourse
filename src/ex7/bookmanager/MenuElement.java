package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class MenuElement {
    int id;
    String title;
    String result;
    Menu menu;

    public MenuElement(int menuElementId, String menuElementTitle, Menu menu, String result) {
        this.id = menuElementId;
        this.title = menuElementTitle;
        this.menu = menu;
        this.result = result;
    }
}
