package task2.Validator;

import task2.Entity.Colors;

public class ColorValidator {
    public boolean isValid (Colors color){
        for (Colors c:Colors.values()
             ) {
            if (color.equals(c)){return true;}
        }
        return false;
    }
}
