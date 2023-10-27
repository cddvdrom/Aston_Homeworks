public interface EmployeeBuilder {
    EmployeeBuilder name(String name);

    EmployeeBuilder position(Position position);

    EmployeeBuilder email(String email);

    EmployeeBuilder phone(String phone);

    EmployeeBuilder salary(double salary);

    EmployeeBuilder age(int age);

    Employee build();
}
