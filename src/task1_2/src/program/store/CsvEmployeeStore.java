package program.store;

import java.io.*;
import java.util.ArrayList;

public class CsvEmployeeStore implements EmployeeStore {
private File db=new File ("db.csv");
    public CsvEmployeeStore(){
        verifyDb();
    }

    @Override
    public void create() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public ArrayList <String []> load() {

        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(db));
            String row;
            ArrayList <String []> dataList=new ArrayList<>();
            while ((row=bufferedReader.readLine())!=null){
                String [] data=   row.split(",");
                dataList.add(data);
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
