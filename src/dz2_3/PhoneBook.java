package dz2_3;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by macuser on 31.01.2018.
 */
public class PhoneBook {

    private HashMap<String, Set<String>> phonesMap;

    public PhoneBook() {
        this.phonesMap = new HashMap<>();
    }

    public HashMap<String, Set<String>> getPhonesMap() {
        return phonesMap;
    }

    public void setPhonesMap(HashMap<String, Set<String>> phonesMap) {
        this.phonesMap = phonesMap;
    }

    public void addPhoneByName(String humanName, String humanPhone) {
        Set<String> phonesByName = getPhonesByName(humanName);
        phonesByName.add(humanPhone);
        phonesMap.put(humanName, phonesByName);
    }

    public Set<String> getPhonesByName(String humanName) {
        Set<String> phones = phonesMap.get(humanName);
        return phones == null ? new HashSet<>() : phones;
    }

    public void printPhones(Set<String> phonesByName) {
        for (String s : phonesByName) {
            System.out.println(s);
        }
    }
}

class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPhoneByName("Иванов", "123431");
        phoneBook.addPhoneByName("Иванов", "123432");
        phoneBook.addPhoneByName("Иванов", "3321233");
        phoneBook.addPhoneByName("Крутикин", "67567");
        phoneBook.addPhoneByName("Хлебов", "552224");

        System.out.println("Все телефоны Иванова:");
        Set<String> phonesByName = phoneBook.getPhonesByName("Иванов");
        phoneBook.printPhones(phonesByName);
    }
}
