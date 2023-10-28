package program.store;

import program.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class CsvEmployeeStore implements EmployeeStore {
    CsvToEmloyeeConverter converter=new CsvToEmloyeeConverter();
private File db=new File ("db.csv");
    public CsvEmployeeStore(){
        verifyDb();
    }

    @Override
    public void create() {

    }

    @Override
    public Optional<Employee> findById(int id) {
        ArrayList <Employee> employees=load();
        for (Employee employee:employees
             ) {
            if(employee.getId()==id){return Optional.of(employee);}
        }
return Optional.empty();
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public ArrayList <Employee> load() {

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(db));
            String row;
            ArrayList <Employee> dataList=new ArrayList<>();
            while ((row=bufferedReader.readLine())!=null){
                String [] data=   row.split(",");
                dataList.add(converter.convert(data));
            }
            bufferedReader.close();
            return  dataList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void verifyDb() {
        File db = new File("db.csv");
        if(!db.exists()){
            try {
                db.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
