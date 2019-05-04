package designpatterns.factorypattern;

import java.rmi.NoSuchObjectException;

public class JavaFactoryPattern {
    public static void main(String a[]) {
        System.out.println(WildAnimalFactory.create("lion").speak());
        System.out.println(WildAnimalFactory.create("elephant").speak());
    }
}

class WildAnimalFactory {
    public static WildAnimal create(String animalName) {
        switch (animalName) {
            case "lion":
                return new Lion();
            case "elephant":
                return new Elephant();
            default:
                return null;
        }
    }

}

interface WildAnimal {
    public String speak();
}

class Lion implements WildAnimal {
    public String speak() {
        return "roar";
    }
}

class Elephant implements WildAnimal {
    public String speak() {
        return "trumphet";
    }
}
