package program.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    public static int count;
    private int id;
    private String name;

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && age == employee.age &&
                Objects.equals(name, employee.name) && position == employee.position &&
                Objects.equals(email, employee.email) && Objects.equals(phone, employee.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, email, phone, salary, age);
    }

    @Override
    public String toString() {
        return "Сотрудник{id =" + id +
                "ФИО= " + name + '\'' +
                ", должность =" + position.getNameOfPosition() +
                ", email='" + email + '\'' +
                ", телефон =" + phone +
                ", заработная плата =" + salary +
                ", возраст =" + age +
                '}';

    }

    public void printEmployee(Employee employee) {
        System.out.println(employee);

    }

    static boolean validate(Employee employee) throws IllegalAccessException, UserValidException, NoSuchFieldError {

return true;
    }

    public class UserValidException extends Exception {

    }
}





