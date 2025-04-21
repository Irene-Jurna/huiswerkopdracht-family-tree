import org.example.Gender;
import org.example.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    Person testPersonWithNameAnne;
    Person testPersonWithOtherGender;
    Person testPersonAnnesMother;
    Person testPersonAnnesFather;

    @BeforeEach
    void setUp() {
        testPersonWithNameAnne = new Person("Anne", "Maria", "Smid", "vrouw", 40);
        testPersonWithOtherGender = new Person("Enric", "Lopez", 35, "non-binair");
        testPersonAnnesMother = new Person ("Mia", "Havinga", 65, "vrouw");
        testPersonAnnesFather = new Person ("Teun", "Smid", 63, "Man");
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

    @Test
    public void testAge() {
        testPersonWithNameAnne.setAge(41);

        int age =  testPersonWithNameAnne.getAge();

        assertEquals(41, age);
    }

    @Test
    public void testAddParents() {
        testPersonWithNameAnne.addParents(testPersonAnnesMother, testPersonAnnesFather);

        assertEquals(testPersonAnnesMother, testPersonWithNameAnne.getMother());
        assertEquals(testPersonAnnesFather, testPersonWithNameAnne.getFather());

        assertTrue(testPersonAnnesMother.getChildren().contains(testPersonWithNameAnne));
        assertTrue(testPersonAnnesFather.getChildren().contains(testPersonWithNameAnne));
    }
}
