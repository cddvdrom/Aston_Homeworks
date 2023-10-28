package program.model;

public class EmployeeBuilderImpl implements EmployeeBuilder {
    Employee employee = new Employee();

    @Override
    public EmployeeBuilder id(int id) {
        employee.setId(Employee.count);
        return this;
    }

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
        Employee.count++;
        return employee;
    }
}