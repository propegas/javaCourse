package ex7.bookmanager;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Menu {
    private String menuTitle;
    private int menuType;
    private MenuElement[] menuElements;

    public Menu(int size) {
        this.setMenuElements(new MenuElement[size]);
    }

    public void addDefaultElement(Menu menu) {
        this.getMenuElements()[0] = (new MenuElement(0, "Выйти в предыдущее меню", menu, ""));
    }

    public void showMenu() {
        System.out.println(this.getMenuTitle());
        for (MenuElement menuElement : this.getMenuElements()) {
            System.out.printf("%d: %s %n", menuElement.getId(), menuElement.getTitle());
        }
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public int getMenuType() {
        return menuType;
    }

    public void setMenuType(int menuType) {
        this.menuType = menuType;
    }

    public MenuElement[] getMenuElements() {
        return menuElements;
    }

    public void setMenuElements(MenuElement[] menuElements) {
        this.menuElements = menuElements;
    }
}
