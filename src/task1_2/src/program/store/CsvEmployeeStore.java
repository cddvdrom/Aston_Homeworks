package program.store;

import program.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class CsvEmployeeStore implements EmployeeStore {
    private File db;

    public CsvEmployeeStore() {

        this.db = verifyDb();
    }


    @Override
    public void create() {

    }

    @Override
    public Optional <Employee> findById(int id) {
        Optional <Employee> employeeOptional;
        ArrayList<Employee> employees = load();
        for (Employee employee : employees
        ) {

            if (employee.getId() == id) {
                employeeOptional=Optional.of(employee);
                return employeeOptional;
            }
        }
        return Optional.ofNullable(null);
    }


    @Override
    public void delete() {

    }

    @Override
    public ArrayList<Employee> load() {
        CsvToEmployeeConverter converter = new CsvToEmployeeConverter();
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(db));
            String row;

            while ((row = bufferedReader.readLine()) != null) {
                String[] data = row.split(",");
                employees.add(converter.convert(data));

            }
            bufferedReader.close();
            return employees;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public File verifyDb() {
        File db = new File("db.csv");
        if (!db.exists()) {
            try {
                db.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return db;
    }

    public void print() {
        ArrayList<Employee> dataList = new ArrayList<>();
        load();
        for (Employee e : dataList
        ) {
            System.out.println(e);
        }
    }
}
