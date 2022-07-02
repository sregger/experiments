package java15;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://www.baeldung.com/java-13-new-features
 */
public class NewFeatures {
    @Test
    public void newRecord() {
        class OldPerson {
            String name;
            int age;
            OldPerson (String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() { return name; };
            public int getAge() { return age; }
            public void add(int years) { age += years; }
            public int compareTo(int years) { return Integer.compare(age, years); }
        }

        var oldPerson = new OldPerson("Tim Keogh", 85);
        assertEquals(oldPerson.getName(), "Tim Keogh");
        assertEquals(oldPerson.getAge(), 85);

        record Person(String name, int age) {
            // Can't do as age is final
            // public void add(int years) { this.age += years; }
            public int compareTo(int years) { return Integer.compare(age, years); }
        } // New type defined within the method

        var person = new Person("Brian Keogh", 45);
        assertEquals(person.name(), "Brian Keogh");
        assertEquals(person.age(), 45);

        assertEquals(1, oldPerson.compareTo(person.age()));
        assertEquals(-1, person.compareTo(oldPerson.getAge()));
    }
}
