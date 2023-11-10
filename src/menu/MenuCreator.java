package menu;

import converter.AppDataToStringListConverter;
import converter.StringListToAppDataConverter;
import entity.AppData;
import display.Display;
import service.InputData;
import service.InputDataService;
import store.DataStore;
import store.FileMenuData;
import validator.AppDataValidator;
import validator.DirectoryValidator;
import validator.MyValidator;

import java.io.File;
import java.util.ArrayList;

public class MenuCreator {
    private MyValidator dirValidator;
    private InputData inputData;
    private StringListToAppDataConverter stringListToAppDataConverter;
    private AppDataToStringListConverter appDatatoStringListConverter;


    public Menu create(Display display, DataStore store) {
        this.stringListToAppDataConverter = new StringListToAppDataConverter();
        this.appDatatoStringListConverter = new AppDataToStringListConverter();
        dirValidator = new DirectoryValidator();
        this.inputData = new InputDataService();
        Menu menu = new Menu(display, "Меню программы");


        menu.add(new MenuEntry("Задать рабочую директорию") {
            @Override
            void run() {
                display.show("Введите рабочую директорию ( .. - для рабочей директории программы)");
                String line = inputData.input();
                if (line.equals(".."))
                {
                    store.setWorkDirectory(new File(System.getProperty("user.dir") + "\\src\\fileData"));
                    System.out.println(System.getProperty("user.dir") + "\\src\\fileData");
                } else
                {
                    if (dirValidator.isValid(line))
                    {
                        store.setWorkDirectory(new File(line));
                        display.show("Рабочая директория установлена : " + line);
                    }
                }
            }
        });

        menu.add(new MenuEntry("Показать рабочую директорию ")
        {
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
                for (int i = 0; i < fileMenuData.getNames().length; i++)
                {
                    int finalI = i;
                    fileMenu.add(new MenuEntry(fileMenuData.getNames()[finalI]) {
                        @Override
                        void run() {
                            AppData appData =
                                    stringListToAppDataConverter.convert(store.load(fileMenuData.getPaths()[finalI]));
                            display.show(appData.toString());
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
                ArrayList<String> result = new ArrayList<>();
                display.show("Введите название файла :");
                String fileName = store.getWorkDirectory() + "\\" + inputData.input() + ".csv";

                    display.show("Сколько строк данных будет в файле ?");
                    int lines = Integer.parseInt(inputData.input());
                    display.show("Сколько столбцов будет в файле ?");
                    int column = Integer.parseInt(inputData.input());
                    if(!new AppDataValidator().validate(column,lines)){
                        display.show("Введены некорректные данные");
                        return;}


                String[] header = new String[column];
                String[][] data = new String[lines][column];
                display.show("Введите значения заголовков");
                for (int i = 0; i < column; i++)
                {
                    display.show("Значение столбца " + (i + 1) + " :");
                    header[i] = inputData.input();
                }
                display.show("Введите данные:");
                for (int j = 0; j < lines; j++)
                {
                    for (int i = 0; i < column; i++) {
                        display.show("Строка " + (j + 1) + ", Cтолбец " + (i + 1)+" "+header[i]);
                        data[j][i] = inputData.input();
                    }
                }
                AppData appData = new AppData(column, lines);
                appData.setData(data);
                appData.setHeader(header);
                store.save(new File(fileName), new AppDataToStringListConverter().convert(appData));
            }
        });


        return menu;


    }
}
