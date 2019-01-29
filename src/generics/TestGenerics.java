package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class TestGenerics {

    public static void main(String... args) {


        Person p1 = new Person(1, "Person1");
        Person p2 = new Person(2, "Person2");
        Person missingPerson = new Person(3, "MissingPerson");

        Car c1 = new Car(1, "Car1");
        Car c2 = new Car(2, "Car2");
        Car missingCar = new Car(3, "MissingCar");

        PersonResponse personResponse = new PersonResponse(new ArrayList<Person>(Arrays.asList(p1, p2)),
                new ArrayList<Person>(Arrays.asList(missingPerson)));

        System.out.println(generateResponse(personResponse));
    }

    public static <T> T generateResponse(T response) {

        return response;
    }
}
