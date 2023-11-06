package Menu;

import Display.Display;
import Service.InputData;
import Service.InputDataService;
import Store.DataStore;
import Validator.DirectoryValidator;
import Validator.MyValidator;

import java.io.File;

public class MenuCreator {
    MyValidator dirValidator;
    InputData inputData;

    public Menu create(Display display, DataStore store) {
        dirValidator = new DirectoryValidator();
        this.inputData = new InputDataService();
        Menu menu = new Menu(display);

        menu.add(new MenuEntry("Exit") {
            @Override
            void run() {

                menu.setExit(true);
            }

        });

        menu.add(new MenuEntry("Задать рабочую директорию") {
            @Override
            void run() {
                display.show("Введите рабочую директорию ( .. - для рабочей директории программы)");
                String line = inputData.input();
                if(line.equals("..")){
                    store.setWorkDirectory(new File(System.getProperty("user.dir")+"\\FileData"));
                    System.out.println(System.getProperty("user.dir") +"\\FileData");
                }
                else {
                    if (dirValidator.isValid(line)) {
                        store.setWorkDirectory(new File(line));
                        display.show("Рабочая директория установлена : "+line);
                    }
                }
            }
        });

        menu.add(new MenuEntry("Показать рабочую директорию ") {
            @Override
            void run() {
                display.show(String.valueOf(store.getWorkDirectory()));
            }
        });
        menu.add(new MenuEntry("Открыть CSV файл") {
            @Override
            void run() {
             store.loadAppDataFromWorkDir();
                System.out.println("punkt 2");
            }
        });

        menu.add(new MenuEntry("Удалить файл") {
            @Override
            void run() {
                System.out.println("punkt 3");
            }
        });

        menu.add(new MenuEntry("Создать новый СSV файл") {
            @Override
            void run() {
                System.out.println("punkt 4");
            }
        });
        menu.add(new MenuEntry("Сохранить изменения в БД") {
            @Override
            void run() {
                System.out.println("punkt 4");
            }
        });



        return menu;


    }
}
