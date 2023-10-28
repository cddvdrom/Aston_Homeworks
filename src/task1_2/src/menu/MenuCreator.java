package menu;

public class MenuCreator {
    public Menu create () {
        Menu menu =new Menu();
        menu.addEntry(new MenuEntry("Вывести всех сотрудников") {
            @Override
            public void run() {
                System.out.println("run 1");
            }
        });

        menu.addEntry(new MenuEntry("Добавить нового сотрудника") {
            @Override
            public void run() {
                System.out.println("run 2");
            }
        });

        menu.addEntry(new MenuEntry("Вывести данные сотрудника") {
            @Override
            public void run() {
                System.out.println("run 3");
            }
        });

        menu.addEntry(new MenuEntry("Удалить сотрудника") {
            @Override
            public void run() {
                System.out.println("run 4");
            }
        });

        menu.addEntry(new MenuEntry("Изменить данные сотрудника") {
            @Override
            public void run() {
                System.out.println("run 5");
            }
        });


        return menu;
    }
}
