package program.menu;

import program.model.Employee;
import program.store.EmployeeStore;


import java.io.IOException;
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
                if (employeeStore.getEmployees().size() != 0) {
                    for (Employee employee : employeeStore.getEmployees()
                    ) {

                        System.out.println(employee);

                    }
                } else {
                    System.out.println("База сотрудников пуста");
                }

            }
        });
/*
        menu.addEntry(new MenuEntry("Добавить нового сотрудника") {
            @Override
            public void run() {
                System.out.println("run 2");
            }
        });
*/

        menu.addEntry(new MenuEntry("Вывести сотрудников старше 40 лет ") {
            @Override
            public void run() {
              employeeStore.getEmployees().stream().filter(x->x.getAge()>40).forEach(System.out::println);

            }
        });

        menu.addEntry(new MenuEntry("Вывести данные сотрудника") {

            @Override
            public void run() {
                Menu menu1 = new Menu();
                menu1.addEntry(new MenuEntry("Ввод Id сотрудника") {

                    @Override
                    public void run() {

                        System.out.println("Введите ID :");
                        try {

                            Optional<Employee> optional = employeeStore.findById(Integer.parseInt(menu1.getReader().readLine()));
                            if (optional.isPresent()) {
                                System.out.println(optional.get());
                            } else {
                                System.out.println("Сотрудника с данным ID нет в БД");
                            }

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
                Menu menu = new Menu();
                menu.addEntry(new MenuEntry("Ввод ID удаляемого сотрудника") {
                    @Override
                    public void run() {
                        System.out.println("Введите ID : ");
                        try {
                            int id = Integer.parseInt(menu.getReader().readLine());
                            if (employeeStore.delete(id)) {
                                System.out.println("Cотрудник " + id + "успешно удален ");
                            } else {
                                System.out.println("Cотрудник " + id + "не найден ");
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

                menu.run();
            }
        });
        menu.addEntry(new MenuEntry("Сохранить изменения в БД") {
            @Override
            public void run() {
                employeeStore.save();
            }
        });


        return menu;
    }

}
