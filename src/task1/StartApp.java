package task1;

public class StartApp {
    public static void main(String[] args) {
        String [] data = {"Абакум", "Абакум", "Абакум", "Абакум", "Абакум", "Абакум", "Абрам", "Абросим", "Аввакум",
                "Август", "Авдий", "Авель", "Авенир", "Аверий", "Аверкий", "Аверьян", "Авксентий", "Аверкий"
                , "Аверьян", "Авксентий", "Авксентий" };
        WordAnalyser analyser = new WordAnalyser();

        long start = System.currentTimeMillis();
        System.out.println( "Список уникальных слов : " + analyser.analyze1 (data).keySet() );
        System.out.println( "Количество повторений : " + analyser.analyze1 (data) );
        long finish = System.currentTimeMillis();
        long time = finish-start;
        System.out.println(time);

        start = System.currentTimeMillis();
        System.out.println( "Список уникальных слов : " + analyser.analyze2 (data).keySet() );
        System.out.println( "Количество повторений : " + analyser.analyze2 (data) );
         finish = System.currentTimeMillis();
        time = finish-start;
        System.out.println(time);

        start = System.currentTimeMillis();
        System.out.println( "Список уникальных слов : " + analyser.analyze3 (data).keySet() );
        System.out.println( "Количество повторений : " + analyser.analyze3 (data) );
        finish = System.currentTimeMillis();
        time = finish-start;
        System.out.println(time);

        start = System.currentTimeMillis();
        System.out.println( "Список уникальных слов : " + analyser.analyze4 (data).keySet() );
        System.out.println( "Количество повторений : " + analyser.analyze4 (data) );
        finish = System.currentTimeMillis();
        time = finish-start;
        System.out.println(time);

    }
}
