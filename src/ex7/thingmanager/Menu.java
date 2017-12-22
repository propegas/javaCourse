package ex7.thingmanager;

import java.util.Scanner;

/**
 * Created by vgoryachev on 08.12.2017.
 * Package: ex7.bookmanager.
 */
public class Menu {
    private static Menu currentMenu;
    private static ThingManager thingManager;
    private User user;
    private String menuTitle;
    private int menuType;
    private MenuElement[] menuElements;

    public Menu(int size) {
        this.setMenuElements(new MenuElement[size]);
    }

    public Menu(User user, ThingManager thingManager) {
        this.user = user;
        Menu.thingManager = thingManager;
        currentMenu = createMainMenu();
    }

    private Menu createMainMenu() {
        MenuBuilder menuBuilder = new MenuBuilder();
        return menuBuilder.createMainMenu();
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

    public void start() {
        do {
            currentMenu.showMenu();
            getUserChoice(currentMenu);
        } while (true);
    }

    public void setCurrentMenu(Menu currentMenu) {
        Menu.currentMenu = currentMenu;
    }

    public void getUserChoice(Menu currentMenu) {

        System.out.println("Введите номер пунка меню:");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        Menu selectedMenu = currentMenu.getMenuElements()[(userChoice)].getMenu();
        if (selectedMenu != null) {
            setCurrentMenu(selectedMenu);
        } else {
            System.out.println();

            switch (currentMenu.getMenuType()) {
                case MenuBuilder.MAIN_MENU_INDEX:
                    prepareManageThings(currentMenu.getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.MAIN_BOOK_MENU_INDEX:
                    prepareManageBook(currentMenu.getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.MAIN_MAGNET_MENU_INDEX:
                    prepareManageMagnet(currentMenu.getMenuElements()[userChoice]);
                    break;
                case MenuBuilder.MAIN_DELETE_MENU_INDEX:
                    prepareDeleteThing(currentMenu.getMenuElements()[userChoice]);
                    break;
                default:

            }
        }

    }

    private void prepareDeleteThing(MenuElement menuElement) {
        if (menuElement.getId() == MenuBuilder.THING_DELETE_BY_ID_MENU_ELEMENT_ID) {
            int thingId = user.getThingIdFromUser();
            thingManager.removeThingById(thingId);
        }
        System.out.println(menuElement.getResult());
    }

    private void prepareManageThings(MenuElement menuElement) {
        if (menuElement.getId() == MenuBuilder.SHOW_ALL_MENU_ELEMENT_ID) {
            thingManager.showAllThings();
        } else if (menuElement.getId() == MenuBuilder.DELETE_ALL_MENU_ELEMENT_ID) {
            thingManager.removeAllThings();
        }
        System.out.println(menuElement.getResult());
    }

    private void prepareManageBook(MenuElement menuElement) {
        Book bookInfoFromUser;
        if (menuElement.getId() == MenuBuilder.BOOK_ADD_MENU_ELEMENT_ID) {
            bookInfoFromUser = user.getBookInfoFromUser();
            thingManager.addThing(bookInfoFromUser);
        }
        System.out.println(menuElement.getResult());
    }

    private void prepareManageMagnet(MenuElement menuElement) {
        Magnet magnetInfoFromUser;
        if (menuElement.getId() == MenuBuilder.MAGNET_ADD_MENU_ELEMENT_ID) {
            magnetInfoFromUser = user.getMagnetInfoFromUser();
            thingManager.addThing(magnetInfoFromUser);
            System.out.println(menuElement.getResult());
        }
    }

}
