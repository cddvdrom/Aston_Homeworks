package task1;

import java.util.*;
public class GeneratorRandom {
    private final Random random;
    public GeneratorRandom() {
        this.random = new Random();
    }
    public List<Integer> generateList() {
        List<Integer> list = new ArrayList<>();
        int size = getRandomInt(RandomProperties.MIN_ARRAY_SIZE.getValue(),
                RandomProperties.MAX_ARRAY_SIZE.getValue());
        for (int i = 0; i < size; i++) {
            list.add(getRandomInt(RandomProperties.MIN_RANGE.getValue(),
                    RandomProperties.MAX_RANGE.getValue()));
        }
        return list;
    }
    public int getRandomInt(int minRange, int maxRange) {
        return random.nextInt(maxRange - minRange + 1 ) + minRange;
    }
    public enum RandomProperties {
        MIN_RANGE(0),
        MAX_RANGE(100),
        MIN_ARRAY_SIZE(1),
        MAX_ARRAY_SIZE(12);
        private final int value;
        RandomProperties(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
}
