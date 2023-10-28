package program.store;

import program.model.Employee;

import java.io.File;
import java.util.ArrayList;

public interface EmployeeStore {
    void create ();
    Employee findById(int id);

    void delete();
   ArrayList <Employee>load();
    File verifyDb();

}
