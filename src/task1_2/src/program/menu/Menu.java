package program.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuEntry> entries = new ArrayList<>();
    private boolean exit = false;

    public Menu() {
        entries.add(new MenuEntry("Exit") {
            @Override
            public void run() {
                exit = true;
            }
        });
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!exit) {
            outputMenu();
            String line = null;
            try {
                line = reader.readLine();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (validateInput(line)) {
                int entry = Integer.parseInt(line);
                MenuEntry menuEntry = entries.get(entry);
                menuEntry.run();
            }
        }
    }

    public void outputMenu() {
        for (int i = 1; i < entries.size(); i++) {
            System.out.println(i + " " + entries.get(i).getTitle());

        }
        System.out.println(0 + " " + entries.get(0).getTitle());
    }

    public void addEntry(MenuEntry menuEntry) {
        entries.add(menuEntry);
    }

    public boolean validateInput(String line) {
        try {
            int intValue = Integer.parseInt(line);
            if (intValue < entries.size()) {
                return true;
            } else
                System.out.println("Неверный ввод");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод");
            return false;
        }
    }
}
