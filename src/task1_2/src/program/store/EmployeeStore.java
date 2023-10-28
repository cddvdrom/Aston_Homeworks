package program.store;

import program.model.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

public interface EmployeeStore {
    void create ();
    Optional <Employee> findById(int id);

    void delete();
   ArrayList <Employee>load();
    File verifyDb();

}
