package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class MenuElement {
    private int id;
    private String title;
    private String result;
    private Menu menu;

    public MenuElement() {
        //default
    }

    public MenuElement(int menuElementId, String menuElementTitle, Menu menu, String result) {
        this.setId(menuElementId);
        this.setTitle(menuElementTitle);
        this.setMenu(menu);
        this.setResult(result);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
