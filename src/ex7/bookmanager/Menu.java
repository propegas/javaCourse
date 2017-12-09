package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Menu {
    String menuTitle;
    int menuType;
    MenuElement[] menuElements;
    Menu previousMenu;

    public Menu(int size) {
        this.menuElements = new MenuElement[size];
    }

    public void addDefaultElement(Menu menu) {
        this.menuElements[0] = (new MenuElement(0, "Выйти в предыдущее меню", menu, ""));
    }

    public void showMenu() {
        System.out.println(this.menuTitle);
        for (MenuElement menuElement : this.menuElements) {
            System.out.printf("%d: %s %n", menuElement.id, menuElement.title);
        }
    }
}
