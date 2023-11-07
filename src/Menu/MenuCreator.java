package Menu;

import Converter.AppDatatoStringListConverter;
import Converter.StringListToAppDataConverter;
import Data.AppData;
import Display.Display;
import Service.InputData;
import Service.InputDataService;
import Store.DataStore;
import Validator.DirectoryValidator;
import Validator.MyValidator;

import java.io.File;

public class MenuCreator {
    private MyValidator dirValidator;
    private InputData inputData;
    private StringListToAppDataConverter stringListToAppDataConverter;
    private AppDatatoStringListConverter appDatatoStringListConverter;


    public Menu create(Display display, DataStore store) {
        this.stringListToAppDataConverter = new StringListToAppDataConverter();
        this.appDatatoStringListConverter = new AppDatatoStringListConverter();
        dirValidator = new DirectoryValidator();
        this.inputData = new InputDataService();
        Menu menu = new Menu(display, "Меню программы");


        menu.add(new MenuEntry("Задать рабочую директорию") {
            @Override
            void run() {
                display.show("Введите рабочую директорию ( .. - для рабочей директории программы)");
                String line = inputData.input();
                if (line.equals("..")) {
                    store.setWorkDirectory(new File(System.getProperty("user.dir") + "\\FileData"));
                    System.out.println(System.getProperty("user.dir") + "\\FileData");
                } else {
                    if (dirValidator.isValid(line)) {
                        store.setWorkDirectory(new File(line));
                        display.show("Рабочая директория установлена : " + line);
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
                FileMenuData fileMenuData = store.loadAppDataFromWorkDir();
                Menu fileMenu = new Menu(display, "Выберите файл ");
                for (int i = 0; i < fileMenuData.getNames().length; i++) {
                    int finalI = i;
                    fileMenu.add(new MenuEntry(fileMenuData.getNames()[finalI]) {
                        @Override
                        void run() {
                            System.out.println(store.load(fileMenuData.getPaths()[finalI]));
/*
                            AppData appData =
                                    stringListToAppDataConverter.convert(store.load(fileMenuData.getPaths()[finalI]));
                            display.show(appData.toString());

 */
                        }
                    });
                }
                fileMenu.run();
            }
        });

        menu.add(new MenuEntry("Удалить файл") {
            @Override
            void run() {
                FileMenuData fileMenuData = store.loadAppDataFromWorkDir();
                Menu fileMenu = new Menu(display, "Выберите файл ");
                for (int i = 0; i < fileMenuData.getNames().length; i++) {
                    int finalI = i;
                    fileMenu.add(new MenuEntry(fileMenuData.getNames()[finalI]) {
                        @Override
                        void run() {
                            store.delete(fileMenuData.getPaths()[finalI]);
                            fileMenu.getMenuEntries().remove(finalI);
                        }
                    });
                }
                fileMenu.run();
            }
        });

        menu.add(new MenuEntry("Создать новый СSV файл") {
            @Override
            void run() {
                System.out.println("punkt 4");
            }
        });


        return menu;


    }
}
