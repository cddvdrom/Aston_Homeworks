package program.store;

import program.model.Employee;

import java.util.ArrayList;
import java.util.Optional;

public interface EmployeeStore {
    void create ();
    Employee findById(int id);

    void delete();
   void load();
    void verifyDb();

}
