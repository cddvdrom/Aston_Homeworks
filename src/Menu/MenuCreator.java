package Menu;

public class MenuCreator {

    public Menu create(){
        Menu menu=new Menu();
        menu.getMenuEntries().add(new MenuEntry() {
            @Override
            void run() {

            }
        });
        return menu;


    }
}
