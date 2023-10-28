package program.store;

import program.model.Employee;

import program.model.EmployeeBuilderImpl;
import program.model.EmployeeValidator;
import program.model.Position;



public class CsvToEmloyeeConverter {
    public Employee convert (String [] data){
        EmployeeValidator validator=new EmployeeValidator();
        if (validator.validate(data)) {
            Employee employee = new EmployeeBuilderImpl().id(Integer.parseInt(data[0])).
                    name(data[1]).
                    salary(Double.parseDouble(data[2])).
                    age(Integer.parseInt(data[3])).
                    position(Position.CASHIER).
                    email(data[5]).
                    phone(data[6]).
                    build();
            return employee;
        }
        return null;
    }
}
