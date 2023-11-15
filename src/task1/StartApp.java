package task1;

public class StartApp {
    public static void main(String[] args) {
        String[] data = {"Абакум", "Абакум", "Абакум", "Абакум", "Абакум", "Абакум", "Абрам", "Абросим", "Аввакум",
                "Август", "Авдий", "Авель", "Авенир", "Аверий", "Аверкий", "Аверьян", "Авксентий", "Аверкий"
                , "Аверьян", "Авксентий", "Авксентий" };
        WordAnalyser analyser = new WordAnalyser();
        System.out.println("Список уникальных слов : "+analyser.analyze(data).keySet());
        System.out.println("Количество повторений : "+ analyser.analyze(data));
    }
}
