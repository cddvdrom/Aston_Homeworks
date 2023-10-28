package program.menu;

import program.store.CsvToEmloyeeConverter;
import program.store.EmployeeStore;

import java.util.ArrayList;


public class MenuCreator {
    private EmployeeStore employeeStore;

    public MenuCreator(EmployeeStore employeeStore) {
        this.employeeStore = employeeStore;
    }

    public Menu create() {
        Menu menu = new Menu();
        menu.addEntry(new MenuEntry("Вывести всех сотрудников") {
            @Override
            public void run() {
                CsvToEmloyeeConverter converter = new CsvToEmloyeeConverter();
                ArrayList<String[]> dataList = employeeStore.load();
                for (String[] data : dataList
                ) {
                    System.out.println(converter.convert(data));
                }


            }
        });

        menu.addEntry(new MenuEntry("Добавить нового сотрудника") {
            @Override
            public void run() {
                System.out.println("run 2");
            }
        });

        menu.addEntry(new MenuEntry("Вывести данные сотрудника") {
            @Override
            public void run() {
                System.out.println("run 3");
            }
        });

        menu.addEntry(new MenuEntry("Удалить сотрудника") {
            @Override
            public void run() {
                System.out.println("run 4");
            }
        });

        menu.addEntry(new MenuEntry("Изменить данные сотрудника") {
            @Override
            public void run() {
                System.out.println("run 5");
            }
        });


        return menu;
    }
}
