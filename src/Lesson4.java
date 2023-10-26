public class Lesson4 {
    public static void main(String[] args) {
        Employee employee1 = new EmployeeBuilderImpl().
                name("Петров Петр Петрович").
                salary(100000).
                age(33).
                position(Position.CASHIER).
                email("petrov@ya.ru").
                phone("213378888").build();



        System.out.println(employee1);
    }
}
