package program.store;

import program.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class CsvEmployeeStore implements EmployeeStore {
    private ArrayList<Employee> employees ;
    private File db;

    private CsvToEmployeeConverter converter;

    public CsvEmployeeStore() {
        this.converter = new CsvToEmployeeConverter();
        this.employees=new ArrayList<>();
        verifyDb();
        db=new File("db.csv");
    }


    @Override
    public void create() {

    }

    @Override
    public Employee findById(int id) {
      load();
print();
        for (Employee employee : employees
        ) {

            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }


    @Override
    public void delete() {

    }

    @Override
    public void load() {
        employees.clear();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(db));
            String row;

            while ((row = bufferedReader.readLine()) != null) {
                String[] data = row.split(",");
                employees.add(converter.convert(data));
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void verifyDb() {
        File db = new File("db.csv");
        if (!db.exists()) {
            try {
                db.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
