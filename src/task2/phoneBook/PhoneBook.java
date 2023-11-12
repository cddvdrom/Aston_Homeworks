package task2.phoneBook;

import java.util.*;

public class PhoneBook {
    private Map<String, Contact> phoneEntries;

    public PhoneBook() {
        this.phoneEntries = new HashMap<>();
    }

    public void add(String surname, Long phone) {
        Set<Map.Entry<String, Contact>> entrySet = phoneEntries.entrySet();
        Set<String> surnames = phoneEntries.keySet();
        for (String key : surnames
        ) {
            if (key.equals(surname)) {
                phoneEntries.get(key).addPhone(phone);
            } else {
                phoneEntries.put(surname, new Contact());
            }
        }
    }
    public ArrayList <String> findAbonent(String surname){
        List <String>
        return null;
    }
}
