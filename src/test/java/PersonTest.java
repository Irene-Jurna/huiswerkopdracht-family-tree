import org.example.Gender;
import org.example.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    Person testPersonWithNameAnne;
    Person testPersonWithOtherGender;

    @BeforeEach
    void setUp() {
        testPersonWithNameAnne = new Person("Anne", "Maria", "Smid", "vrouw", 40);
        testPersonWithOtherGender = new Person("Enric", "Lopez", 35, "non-binair");
    }

    @Test
    public void testGetName() {
        String name = testPersonWithNameAnne.getName();

        assertEquals("Anne", name);
    }

    @Test
    public void testSetName() {
        testPersonWithNameAnne.setName("Loes");

        assertEquals("Loes", testPersonWithNameAnne.getName());
    }

    @Test
    public void testGetGender() {
        Gender sex = testPersonWithOtherGender.getSex();

        assertEquals(Gender.NON_BINAIR, testPersonWithOtherGender.getSex());
    }
}
