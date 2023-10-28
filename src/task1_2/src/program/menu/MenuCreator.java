package program.menu;

import program.model.Employee;
import program.model.EmployeeValidator;

import program.store.CsvEmployeeStore;
import program.store.CsvToEmployeeConverter;
import program.store.EmployeeStore;


import java.io.IOException;

import java.util.ArrayList;





public class MenuCreator {
    private Menu menu;
    private EmployeeValidator validator;
    private CsvToEmployeeConverter converter;
    private EmployeeStore employeeStore;

    public MenuCreator() {
        this.employeeStore = new CsvEmployeeStore();
        this.converter=new CsvToEmployeeConverter();
        this.validator=new EmployeeValidator();
    }

    public Menu create() {
        Menu menu = new Menu();
        ArrayList<Employee> dataList =employeeStore. ;
        menu.addEntry(new MenuEntry("Вывести всех сотрудников") {
            @Override
            public void run() {



                for (Employee employee : dataList
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
                            //Optional <Employee> optional;
                            //optional = employeeStore.findById(Integer.parseInt(menu1.getReader().readLine()));
                            //optional.ifPresent(System.out::println);
                            String s=menu1.getReader().readLine();

                            System.out.println(employeeStore.findById(Integer.parseInt(s)));

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
