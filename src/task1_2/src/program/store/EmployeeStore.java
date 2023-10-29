package program.store;

import program.model.Employee;

import java.util.ArrayList;
import java.util.Optional;

public interface EmployeeStore {
    void create();

    Optional<Employee> findById(int id);

    boolean delete(int id);

    ArrayList<Employee> load();

    ArrayList<Employee> getEmployees();

    void setEmployees(ArrayList<Employee> employees);
    void save();

}
