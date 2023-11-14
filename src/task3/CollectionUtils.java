package task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public <T> List<T> sortElementsInNaturalOrder(List<T> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }
    public List <String> sortWordsCollectionInNaturalOrder (List <String> list){
        return list.stream().map(x -> Arrays.stream(x.split("")).
                        sorted().collect(Collectors.toList())).
                map(x -> String.join("", x)).collect(Collectors.toList());
    }
}
