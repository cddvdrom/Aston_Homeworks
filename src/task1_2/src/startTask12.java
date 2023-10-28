
import menu.MenuCreator;
import store.CsvEmployeeStore;
import store.EmployeeStore;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class startTask12 {
    public static void main(String[] args) {
        EmployeeStore employeeStore=new CsvEmployeeStore();
        MenuCreator menuCreator = new MenuCreator();
        menuCreator.create().run();




    }

    public static ArrayList<Employee> createListOfEmployees() {

        ArrayList<Employee> employees = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String toString() {
                StringBuilder employees = new StringBuilder();
                for (Employee employee : this) {
                    employees.append(employee.toString());
                    employees.append("\n");
                }
                return employees.toString();
            }
        };


        employees.add(new EmployeeBuilderImpl().id().
                name("Петров Петр Петрович").
                salary(44000).
                age(33).
                position(Position.CASHIER).
                email("petrov@ya.ru").
                phone("213378888").build());

        employees.add(new EmployeeBuilderImpl().id().
                name("Иванов Иван Иванович").
                salary(100000).
                age(55).
                position(Position.DIRECTOR).
                email("ivanoc@mail.ru").
                phone("6598989874").build());

        employees.add(new EmployeeBuilderImpl().id().
                name("Сидоров Сидор Сидорович").
                salary(10000).
                age(20).
                position(Position.MANAGER).
                email("sidorov@mail.ru").
                phone("465656844").build());

        employees.add(new EmployeeBuilderImpl().id().
                name("Алексеев Алексей Алексеевич").
                salary(50000).
                age(40).
                position(Position.TECHNOLOGIST).
                email("alekseev@mail.ru").
                phone("9989898884").build());

        employees.add(new EmployeeBuilderImpl().id().
                name("Макарова Мария Макаровна").
                salary(30000).
                age(33).
                position(Position.ACCOUNTANT).
                email("makarova@mail.ru").
                phone("365656444").build());


        return employees;
    }
public static void loadEmloyeesFromFile() throws IOException {
    File db = new File("db.csv");
    if(!db.exists()){db.createNewFile();}
}

}
