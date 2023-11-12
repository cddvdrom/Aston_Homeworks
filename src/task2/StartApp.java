package task2;

import task2.phoneBook.PhoneBook;

public class StartApp {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов","9213332211");
        phoneBook.add("Петров","9111113344");
        phoneBook.add("Сидоров","9061234567");
        phoneBook.add("Иванов","9312221100");
        phoneBook.printFindAbonent ("Иванов",phoneBook.findAbonent("Иванов"));
    }
}
