import DataLoader.DisplayLoader;
import DataLoader.FileTypeLoader;
import Display.*;
import Menu.Menu;
import Menu.MenuCreator;
import Store.CsvStore;
import Store.DataStore;

public class Start {
    public static void main(String[] args) {
        DisplayLoader displayLoader=new DisplayLoader();
        Display display=displayLoader.load();
        FileTypeLoader fileTypeLoader=new FileTypeLoader();
        DataStore store= fileTypeLoader.load();
        MenuCreator menuCreator=new MenuCreator();
        Menu menu=menuCreator.create(display,store);
        menu.run();

    }
}
