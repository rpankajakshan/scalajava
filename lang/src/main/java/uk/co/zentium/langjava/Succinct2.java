package uk.co.zentium.langjava;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.Assert.assertEquals;

public class Succinct2 {

    private static class Person {

        private final String id;
        private final String name;
        private int age;

        private Person(String id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    private static OptionalDouble getAverageAge(List<Person> people) {

        return people
                .stream()
                .mapToInt(item -> item.age)
                .average();
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("id1", "rp1", 20));
        people.add(new Person("id2", "rp2", 40));
        assertEquals(getAverageAge(people).orElse(0.0), 30.0, 0.0);
    }
}
