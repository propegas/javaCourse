package dz_5;

/**
 * Created by vgoryachev on 12.01.2018.
 * Package: dz_5.
 */
public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[5];

        people[0] = new Person("Иван Лопатин", "Инженер", "lopatin@v_sovke.com", "", 43, 96000);
        people[1] = new Person("Елена Кротова", "Менеджер", "krotova@v_sovke.com", "+79003698521", 39, 89000);
        people[2] = new Person("Валентин Супрыгин", "Старший специалист", "suprygin@potop.net", "+79003216579", 36, 89000);
        people[3] = new Person("Игорь Саруханов", "Разработчик", "saruhanov@igor.net", "+79009874539", 43, 70000);
        people[4] = new Person("Людимла Побегушкина", "Секретарь", "blondinka@mosgov.net", "+79004587123", 26, 60000);

        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            if (person.getAge() > 40) {
                showPerson(person);
            }
        }
    }

    private static void showPerson(Person person) {
        System.out.println();
        System.out.println(String.format("Имя: %s", person.getName()));
        System.out.println(String.format("Возраст: %s", person.getAge()));
        System.out.println(String.format("Должность: %s", person.getTitle()));
        System.out.println(String.format("Электропочта: %s", person.getEmail()));
        System.out.println(String.format("Телефон: %s", person.getPhone()));
        System.out.println(String.format("Зарплата: %s %s", person.getSalary(), "рублей"));
        System.out.println("===================");
    }
}
