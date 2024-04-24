package dk.kea.dat3js.hogwarts5.teachers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getFullNameWithMiddleName() {
        Teacher t = new Teacher("Severus", "Prince", "Snape", null, "Subject", null);

        String fullName = t.getFullName();
        String expected = "Severus Prince Snape";

        assertEquals(expected, fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        Teacher t = new Teacher("Albus", "Dumbledore", null, "Subject", null);


        String fullName = t.getFullName();
        String expected = "Albus Dumbledore";

        assertEquals(expected, fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFullName("Severus Prince Snape");

        String expectedFirst = "Severus";
        String expectedMiddle = "Prince";
        String expectedLast = "Snape";

        assertEquals(expectedFirst, t.getFirstName());
        assertEquals(expectedMiddle, t.getMiddleName());
        assertEquals(expectedLast, t.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFullName("Albus Dumbledore");

        String expectedFirst = "Albus";
        String expectedLast = "Dumbledore";

        assertEquals(expectedFirst, t.getFirstName());
        assertEquals(expectedLast, t.getLastName());
        assertNull(t.getMiddleName());
    }

    @Test
    void setFullNameWithoutLastName() {}

    @Test
    void setFullNameWithMultipleMiddleNames() {
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFullName("Albus Percival Wulfric Brian Dumbledore");

        String expectedFirst = "Albus";
        String expectedMiddle = "Percival Wulfric Brian";
        String expectedLast = "Dumbledore";

        assertEquals(expectedFirst, t.getFirstName());
        assertEquals(expectedMiddle, t.getMiddleName());
        assertEquals(expectedLast, t.getLastName());
    }

    @Test
    void setFullNameWithEmptyString(){
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFullName("");

        assertNull(t.getFirstName());
        assertNull(t.getMiddleName());
        assertNull(t.getLastName());
    }

    @Test
    void setFullNameWithNull(){
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFullName(null);

        assertNull(t.getFirstName());
        assertNull(t.getMiddleName());
        assertNull(t.getLastName());
    }

    @Test
    void capitalizeIndividualNames(){
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFirstName("severus");
        t.setMiddleName("prince");
        t.setLastName("snape");

        String expectedFirst = "Severus";
        String expectedMiddle = "Prince";
        String expectedLast = "Snape";

        assertEquals(expectedFirst, t.getFirstName());
        assertEquals(expectedMiddle, t.getMiddleName());
        assertEquals(expectedLast, t.getLastName());
    }

    @Test
    void capitalizeIndividualNamesWithCrazyCapitalization(){
        Teacher t = new Teacher("first", "middle", "last", null, "Subject", null);

        t.setFirstName("sEVeRuS");
        t.setMiddleName("pRiNCe");
        t.setLastName("sNapE");

        String expectedFirst = "Severus";
        String expectedMiddle = "Prince";
        String expectedLast = "Snape";

        assertEquals(expectedFirst, t.getFirstName());
        assertEquals(expectedMiddle, t.getMiddleName());
        assertEquals(expectedLast, t.getLastName());
    }
}