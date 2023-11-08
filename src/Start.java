import dataLoader.DisplayLoader;
import dataLoader.FileTypeLoader;
import display.*;
import menu.Menu;
import menu.MenuCreator;
import store.DataStore;

public class Start {
    public static void main(String[] args) {

        Display display=new DisplayLoader().load();
        DataStore store= new FileTypeLoader().load();
        new MenuCreator().create(display,store).run();


    }
}
