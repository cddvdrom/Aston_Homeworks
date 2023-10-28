package program.menu;

import program.model.Employee;
import program.store.EmployeeStore;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Optional;


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

                for (Employee employee : employeeStore.load()
                ) {

                        System.out.println(employee);

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
                Menu menu1=new Menu();
                menu1.addEntry(new MenuEntry("Ввод Id сотрудника") {

                    @Override
                    public void run() {

                        System.out.println("Введите ID :");
                        try {

                            Optional<Employee> optional = employeeStore.findById(Integer.parseInt(menu1.getReader().readLine()));
                            optional.ifPresent(System.out::println);

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



        return menu;
    }

}
