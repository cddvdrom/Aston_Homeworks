package task2.phoneBook;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private List <Long> phones;
    public Contact (){
        this.phones=new ArrayList<>();
    }
    public Contact(Long phone){
        this.phones=new ArrayList<>();
        this.phones.add(phone);
    }
    public void addPhone(Long phone){
        phones.add(phone);
    }
}
