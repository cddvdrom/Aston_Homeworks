package task5;

public class StartApp {
    public static void main(String[] args) {
        Data data = new Data();
        OuterInConcole printer = new OuterInConcole();
        SearchCondition condition = String::startsWith;
        InputData inputData = new InputData();
        System.out.println("Введите логины ,при завершении введите пустую строку :");
        data.setData(inputData.input());
        System.out.println("Список логинов , которые начинаются на f : ");
        printer.printList(data.findDataCondition( condition, "f"));
    }
}
