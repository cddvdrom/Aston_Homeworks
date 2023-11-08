package service;

import menu.*;

import java.util.ArrayList;

public class OutputMenu {


    public String output(ArrayList<MenuEntry> menuEntries,String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=================");
        stringBuilder.append("\n");
        stringBuilder.append(name+" :");
        stringBuilder.append("\n");
        stringBuilder.append("=================");
        stringBuilder.append("\n");
        for (int i = 1; i < menuEntries.size(); i++) {
            stringBuilder.append(i + ". ");
            stringBuilder.append(menuEntries.get(i).getName());
            stringBuilder.append("\n");
        }
        stringBuilder.append(0 + ". " + menuEntries.get(0).getName());
        stringBuilder.append("\n");
        stringBuilder.append("=================");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}