package task1.Service;

import task1.Entity.Animal;
import task1.Entity.Pork;
import task1.Result.Result;

public interface AnimalService {
    Result run(Animal animal, int distance);

    Result swim(Animal animal, int distance);

    Result eat(Animal animal, Pork pork);
}
