package dz_5;

/**
 * Created by vgoryachev on 12.01.2018.
 * Package: dz_5.
 */
public class Person {
    private String name;
    private String title;
    private String email;
    private String phone;

    private int age;
    private int salary;

    public Person(String name, String title, String email, String phone, int age, int salary) {
        this.name = name;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
