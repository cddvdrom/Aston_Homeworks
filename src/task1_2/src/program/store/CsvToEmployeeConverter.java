package program.store;

import program.model.Employee;

import program.model.EmployeeBuilderImpl;

import program.model.Position;

import java.util.Arrays;
import java.util.stream.Collectors;


public class CsvToEmployeeConverter {
    public Employee convert(String[] data) {


        Employee employee = new EmployeeBuilderImpl().id(Integer.parseInt(data[0])).
                name(data[1]).
                salary(Double.parseDouble(data[2])).
                age(Integer.parseInt(data[3])).
                position(Arrays.asList(Position.values()).stream().
                        filter(x -> x.getNameOfPosition().equals(data[4])).collect(Collectors.toList()).get(0)).
                email(data[5]).
                phone(data[6]).
                build();
        return employee;


    }
}
