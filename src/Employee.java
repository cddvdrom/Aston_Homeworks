public class Employee {

    private String name;

    private Position position;

    private String email;

    private String phone;

    private double salary;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "ФИО='" + name + '\'' +
                ", должность =" + position.getNameOfPosition() +
                ", email='" + email + '\'' +
                ", телефон =" + phone +
                ", заработная плата =" + salary +
                ", возраст =" + age +
                '}' ;

    }
}


interface EmployeeBuilder {
    EmployeeBuilder name(String name);

    EmployeeBuilder position(Position position);

    EmployeeBuilder email(String email);

    EmployeeBuilder phone(String phone);

    EmployeeBuilder salary(double salary);

    EmployeeBuilder age(int age);

    Employee build();
}

class EmployeeBuilderImpl implements EmployeeBuilder {
    Employee employee = new Employee();

    @Override
    public EmployeeBuilder name(String name) {
        employee.setName(name);
        return this;
    }

    @Override
    public EmployeeBuilder position(Position position) {
        employee.setPosition(position);
        return this;
    }

    @Override
    public EmployeeBuilder email(String email) {
        employee.setEmail(email);
        return this;
    }

    @Override
    public EmployeeBuilder phone(String phone) {
        employee.setPhone(phone);
        return this;
    }

    @Override
    public EmployeeBuilder salary(double salary) {
        employee.setSalary(salary);
        return this;
    }

    @Override
    public EmployeeBuilder age(int age) {
        employee.setAge(age);
        return this;
    }

    @Override
    public Employee build() {
        return employee;
    }
}

enum Position {
    DIRECTOR("директор"),
    ACCOUNTANT("бухгалтер"),
    TECHNOLOGIST("технолог"),
    MANAGER("менеджер"),
    CASHIER("кассир");

    private String name;

    Position(String name) {
        this.name = name;
    }

    public String getNameOfPosition() {
        return name;
    }
}
