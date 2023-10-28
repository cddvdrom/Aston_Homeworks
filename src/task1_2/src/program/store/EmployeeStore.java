package program.store;

import java.util.ArrayList;

public interface EmployeeStore {
    void create ();
    void findById();
    void update ();
    void delete();
    ArrayList<String []> load();
    void verifyDb();

}
