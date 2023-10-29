package program.validator;

import program.model.Position;

public class Validator {
    public boolean validateId(String id) {
        if(id==null){return false;}
        int i;
        try {
            i = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return false;
            }
        return true;
    }

    public boolean validateName(String name) {
        if(name==null){return false;}
        if(name.matches("^[а-яА-Я\\s]*$")){return true;}
        return false;

    }

    public boolean validateEmail(String email) {
        if(email.matches("^[\\w.-]+@[\\w-]+\\.\\w+$")){return true;}
        return false;
    }

    public boolean validatePhone(String phone) {
        if(phone.matches("^\\d{10}$")){return true;}
        return false;
    }

    public boolean validateSalary(String salary) {
        double i;
        try {
            i = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateAge(String age) {

        int i;
        try {
            i = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validatePosition(String position) {
        for (Position p:Position.values()
             ) {
            if(p.getNameOfPosition().equals(position)){return true;}
        }
        return false;
    }
}
