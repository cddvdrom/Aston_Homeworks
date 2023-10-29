import java.util.ArrayList;

public class Park {
    private ArrayList<Attraction> attractions;

    public Park() {
        this.attractions = new ArrayList<>();
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }



    public void addAttraction(String name, int time, double cost) {
        attractions.add(new Attraction(name, time, cost));
    }

    public class Attraction {
        private String name;
        private int time;
        private double cost;

        public Attraction(String name, int time, double cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Attraction{" +
                    "name='" + name + '\'' +
                    ", time=" + time +
                    ", cost=" + cost +
                    '}';
        }

        public void printInfo() {

            System.out.println("Аттракцион :" + name);
            System.out.println("Время работы :" + time);
            System.out.println("Cтоимость :" + cost);

        }
    }

}
