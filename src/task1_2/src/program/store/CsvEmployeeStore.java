package program.store;

import program.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class CsvEmployeeStore implements EmployeeStore {
    private final File DB = new File("src/task1_2/src/program/data", "db.csv");

    private ArrayList<Employee> employees;

    public CsvEmployeeStore() {

        this.employees = load();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public void create() {

    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Employee> employeeOptional;

        for (Employee employee : employees
        ) {

            if (employee.getId() == id) {
                employeeOptional = Optional.of(employee);
                return employeeOptional;
            }
        }
        return Optional.ofNullable(null);
    }


    @Override
    public boolean delete(int id) {

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                this.employees.remove(i);

                return true;
            }

        }
        return false;
    }

    @Override
    public ArrayList<Employee> load() {
        CsvToEmployeeConverter converter = new CsvToEmployeeConverter();
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DB));
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


    public void print() {


        for (Employee e : employees
        ) {
            System.out.println(e);
        }
    }
}
