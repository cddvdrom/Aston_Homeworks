package program.store;

import program.model.Employee;

import program.model.EmployeeBuilderImpl;

import program.model.Position;
import program.validator.Validator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;


public class CsvToEmployeeConverter {
    public Optional <Employee> convert(String[] data) {
        Validator validator=new Validator();
        String id=data[0];
        String name=data[1];
        String salary=data[2];
        String age=data[3];
        String position=data[4];
        String email=data[5];
        String phone=data[6];

        if(!validator.validateId(id)){return Optional.ofNullable(null);}
        if(!validator.validateName(name)){return Optional.ofNullable(null);}
        if(!validator.validateSalary(salary)){salary=null;}
        if(!validator.validateAge(age)){age=null;}
        if(!validator.validatePosition(position)){return Optional.ofNullable(null);}
        if(!validator.validateEmail(email)){email=null;}
        if(!validator.validatePhone(phone)){phone=null;}


        Employee employee = new EmployeeBuilderImpl().id(Integer.parseInt(id)).
                name(name).
                salary(Double.parseDouble(salary)).
                age(Integer.parseInt(age)).
                position(Arrays.asList(Position.values()).stream().
                        filter(x -> x.getNameOfPosition().equals(position)).collect(Collectors.toList()).get(0)).
                email(email).
                phone(phone).
                build();
        return Optional.of(employee);


    }
}
