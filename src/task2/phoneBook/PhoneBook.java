package task2.phoneBook;
import java.util.*;
public class PhoneBook {
    private final ArrayList<String> peoples;
    private final ArrayList<String> phones;
    public PhoneBook(){
        this.peoples = new ArrayList<>();
        this.phones = new ArrayList<>();
    }
    public void add(String surname, String phone) {
        peoples.add(surname);
        phones.add(phone);
    }
    public ArrayList<String> findAbonent(String surname) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < peoples.size(); i++)
        {
            if (peoples.get(i).equals(surname))
            {
                result.add(phones.get(i));
            }
        }
        return result;
    }
    public void printFindAbonent(String surname, ArrayList<String> result) {
        System.out.println("Данные поиска по абоненту - " + surname + " :");
        if (result.size() == 0)
        {
            System.out.println("Абонент с данной фамилией отсутствует в справочнике");
        }
        else
        {
            for (String phone : result)
            {
                System.out.println(phone);
            }
        }
    }
}
