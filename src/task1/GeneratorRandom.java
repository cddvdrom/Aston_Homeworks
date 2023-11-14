package task1;

import java.util.*;
import java.util.stream.Collectors;

public class GeneratorRandom {
    private final Random random;
    public GeneratorRandom() {
        this.random = new Random();
    }
    public List<Integer> generateList() {
            return Arrays.stream(new Integer[getRandomInt(RandomProperties.MIN_ARRAY_SIZE.getValue(),
                    RandomProperties.MAX_ARRAY_SIZE.getValue())]).map
                    (x-> getRandomInt(RandomProperties.MIN_RANGE.getValue(),
                    RandomProperties.MAX_RANGE.getValue())).collect(Collectors.toList());
    }
    public int getRandomInt(int minRange, int maxRange) {
        return random.nextInt(maxRange - minRange + 1 ) + minRange;
    }
    public enum RandomProperties {
        MIN_RANGE(0),
        MAX_RANGE(100),
        MIN_ARRAY_SIZE(1),
        MAX_ARRAY_SIZE(22);
        private final int value;
        RandomProperties(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
}
