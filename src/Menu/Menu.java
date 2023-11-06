package Menu;

import Display.Display;
import Service.OutputMenu;
import Validator.MenuItemValidator;
import Validator.MyValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    private OutputMenu outputMenu;
    private MyValidator validator;
    private Display display;
    private BufferedReader reader;
    private ArrayList<MenuEntry> menuEntries;
    private boolean isExit = false;

    public Menu(Display display) {
        menuEntries = new ArrayList<>();
        outputMenu=new OutputMenu();
        validator = new MenuItemValidator();
        this.display = display;
        this.reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    public ArrayList<MenuEntry> getMenuEntries() {
        return menuEntries;
    }

    public void setMenuEntries(ArrayList<MenuEntry> menuEntries) {
        this.menuEntries = menuEntries;
    }

    public void add(MenuEntry menuEntry) {
        menuEntries.add(menuEntry);
    }

    public void run() {
        while (!isExit) {
            display.show(outputMenu.output(menuEntries));
            String line;
            int item;
            try {
                line = reader.readLine();
                if (validator.isValid(line)) {
                    item = Integer.parseInt(line);
                    if (item >= 0 & item < menuEntries.size()) {
                        menuEntries.get(item).run();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
