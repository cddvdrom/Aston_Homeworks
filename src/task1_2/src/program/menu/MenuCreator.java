package program.menu;

import program.model.Employee;
import program.model.EmployeeValidator;
import program.store.CsvToEmloyeeConverter;
import program.store.EmployeeStore;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class MenuCreator {
    Scanner scanner=new Scanner(System.in);
    EmployeeValidator validator=new EmployeeValidator();
    CsvToEmloyeeConverter converter = new CsvToEmloyeeConverter();
    private EmployeeStore employeeStore;

    public MenuCreator(EmployeeStore employeeStore) {
        this.employeeStore = employeeStore;
    }

    public Menu create() {
        Menu menu = new Menu();
        menu.addEntry(new MenuEntry("Вывести всех сотрудников") {
            @Override
            public void run() {

                ArrayList<Employee> dataList = employeeStore.load();

                for (Employee employee : dataList
                ) {
                    if (validator.validate(employee)) {
                        System.out.println(employee);
                    }
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
                Menu menu1=createCleanMenu();

                menu1.addEntry(new MenuEntry("Ввод Id сотрудника") {
                    @Override
                    public void run() {

                        System.out.println("Введите ID :");
                        int id=scanner.nextInt();
                        Optional <Employee> optional=employeeStore.findById(id);
                        optional.ifPresent(System.out::println);

                    }
                });
                menu1.run();

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
    public  Menu createCleanMenu(){
        return new Menu();
    }
}
