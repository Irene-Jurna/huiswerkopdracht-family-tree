import org.example.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = new Person("Anne", "Maria", "Smid", "vrouw", 40);
    }

    @Test
    public void testGetName() {
        String name = testPerson.getName();

        assertEquals("Anne", name);
    }

    @Test
    public void testSetName() {
        testPerson.setName("Loes");

        assertEquals("Loes", testPerson.getName());
    }
}
