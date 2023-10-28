package program;


import program.menu.MenuCreator;

import program.store.CsvEmployeeStore;
import program.store.EmployeeStore;



public class startTask12 {
    public static void main(String[] args) {
        EmployeeStore employeeStore = new CsvEmployeeStore();
        MenuCreator menuCreator = new MenuCreator(employeeStore);
        menuCreator.create().run();


    }


}



