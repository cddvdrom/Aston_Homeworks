import java.util.ArrayList;
import java.util.Arrays;

public class Lesson4 {
    public static void main(String[] args) {
   ArrayList <Employee> employees=createListOfEmployees();
   System.out.println(employees);


    }
    public static ArrayList <Employee> createListOfEmployees(){
        Employee employee1 = new EmployeeBuilderImpl().
                name("Петров Петр Петрович").
                salary(44000).
                age(33).
                position(Position.CASHIER).
                email("petrov@ya.ru").
                phone("213378888").build();

        Employee employee2 = new EmployeeBuilderImpl().
                name("Иванов Иван Иванович").
                salary(100000).
                age(55).
                position(Position.DIRECTOR).
                email("ivanoc@mail.ru").
                phone("6598989874").build();

        Employee employee3 = new EmployeeBuilderImpl().
                name("Сидоров Сидор Сидорович").
                salary(10000).
                age(20).
                position(Position.MANAGER).
                email("sidorov@mail.ru").
                phone("465656844").build();

        Employee employee4 = new EmployeeBuilderImpl().
                name("Алексеев Алексей Алексеевич").
                salary(50000).
                age(40).
                position(Position.TECHNOLOGIST).
                email("alekseev@mail.ru").
                phone("9989898884").build();

        Employee employee5 = new EmployeeBuilderImpl().
                name("Макарова Мария Макаровна").
                salary(30000).
                age(33).
                position(Position.ACCOUNTANT).
                email("makarova@mail.ru").
                phone("365656444").build();


        ArrayList<Employee> employees = new ArrayList<>() {
            private static final long serialVersionUID = 1L;

            @Override
            public String toString() {
                StringBuilder employees = new StringBuilder();
                for (Employee empl : this) {
                    employees.append(empl.toString());
                    employees.append("\n");
                }
                return employees.toString();
            }
        };
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        return employees;
    }


}
