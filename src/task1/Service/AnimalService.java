package task1.Service;

import task1.Entity.Animal;
import task1.Entity.Pork;

public interface AnimalService {
    void run();
    void swim();
    void eat(Pork pork, Animal animal);
}
