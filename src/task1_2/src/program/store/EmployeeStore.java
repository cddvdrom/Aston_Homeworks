package program.store;

import program.model.Employee;

import java.util.ArrayList;
import java.util.Optional;

public interface EmployeeStore {
    void create ();
    Employee findById(int id);
    void update ();
    void delete();
    ArrayList<Employee> load();
    void verifyDb();

}
