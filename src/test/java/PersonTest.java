import org.example.Gender;
import org.example.Person;
import org.example.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    Person testPersonWithNameAnne;
    Person testPersonWithOtherGender;
    Person testPersonAnnesMother;
    Person testPersonAnnesFather;
    Person testPersonAnnesChild;

    @BeforeEach
    void setUp() {
        testPersonWithNameAnne = new Person("Anne", "Maria", "Smid", "vrouw", 40);
        testPersonWithOtherGender = new Person("Enric", "Lopez", 35, "non-binair");
        testPersonAnnesMother = new Person ("Mia", "Havinga", 65, "vrouw");
        testPersonAnnesFather = new Person ("Teun", "Smid", 63, "Man");
        testPersonAnnesChild = new Person ("Fia", "Maria", "Smid", "vrouw", 2);
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
        testPersonWithNameAnne.addBiologicalParents(testPersonAnnesMother, testPersonAnnesFather);

        assertEquals(testPersonAnnesMother, testPersonWithNameAnne.getMother());
        assertEquals(testPersonAnnesFather, testPersonWithNameAnne.getFather());

        assertTrue(testPersonAnnesMother.getChildren().contains(testPersonWithNameAnne));
        assertTrue(testPersonAnnesFather.getChildren().contains(testPersonWithNameAnne));
    }

    @Test
    public void testAddChild() {
        testPersonAnnesMother.addChild(testPersonWithNameAnne);

        assertEquals(1, testPersonAnnesMother.getChildren().size());
        assertEquals(Arrays.asList(testPersonWithNameAnne), testPersonAnnesMother.getChildren());
    }

    @Test
    public void testAddChildren() {
        Person father = new Person ("Rayan", "Amali", 40, "man");
        Person child1 = new Person ("Mohammed", "Amali", 4, "man");
        Person child2 = new Person ("Eva", "Amali", 0, "v");

        father.addChild(child1);
        father.addChild(child2);

        assertEquals(2, father.getChildren().size());
        assertEquals(Arrays.asList(child1, child2), father.getChildren());
    }

    @Test
    public void testAddPet() {
        Pet cat = new Pet("Kela", 10, "cat");

        testPersonWithNameAnne.addPet(cat);

        assertEquals(1, testPersonWithNameAnne.getPets().size());
        assertEquals(cat, testPersonWithNameAnne.getPets().get(0));
        assertEquals(Arrays.asList(cat), testPersonWithNameAnne.getPets());
    }

    @Test
    public void testNoPets() {
        assertEquals(0, testPersonAnnesMother.getPets().size());
    }

    @Test
    public void testGrandChildren() {
        testPersonAnnesMother.addChild(testPersonWithNameAnne);
        testPersonWithNameAnne.addChild(testPersonAnnesChild);

        // Console-output testen
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        testPersonAnnesMother.getGrandChildren();

        String expectedOutput = testPersonAnnesMother.getName() + "s kleinkinderen zijn: \n- Fia Smid\n";

        assertEquals(expectedOutput, outContent.toString());

        // Herstel console-output
        System.setOut(System.out);
    }
}
