package program.menu;

import program.model.Employee;
import program.model.EmployeeValidator;
import program.store.CsvToEmloyeeConverter;
import program.store.EmployeeStore;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Optional;




public class MenuCreator {
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
            Menu menu1=createCleanMenu();
            @Override
            public void run() {


                menu1.addEntry(new MenuEntry("Ввод Id сотрудника") {
                    @Override
                    public void run() {

                        System.out.println("Введите ID :");
                        try {
                            //Optional <Employee> optional;
                            //optional = employeeStore.findById(Integer.parseInt(menu1.getReader().readLine()));
                            //optional.ifPresent(System.out::println);
                            System.out.println(employeeStore.findById(Integer.parseInt(menu1.getReader().readLine())));

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


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
