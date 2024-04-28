package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullNameWithMiddleName() {
        Student s = new Student("Harry", "James", "Potter", "male", null, false,5);

        String fullName = s.getFullName();
        String expected = "Harry James Potter";

        assertEquals(expected, fullName);
    }

    @Test
    void getFullNameWithoutMiddleName() {
        Student s = new Student("Cho", "Chang", "female", null, false,5);

        String fullName = s.getFullName();
        String expected = "Cho Chang";

        assertEquals(expected, fullName);
    }

    @Test
    void setFullNameWithMiddleName() {
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFullName("Hermione Jean Granger");

        String expectedFirst = "Hermione";
        String expectedMiddle = "Jean";
        String expectedLast = "Granger";

        assertEquals(expectedFirst, s.getFirstName());
        assertEquals(expectedMiddle, s.getMiddleName());
        assertEquals(expectedLast, s.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFullName("Cho Chang");

        String expectedFirst = "Cho";
        String expectedLast = "Chang";

        assertEquals(expectedFirst, s.getFirstName());
        assertEquals(expectedLast, s.getLastName());
        assertNull(s.getMiddleName());
    }

    @Test
    void setFullNameWithoutLastName() {}

    @Test
    void setFullNameWithMultipleMiddleNames() {
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFullName("Albus Percival Wulfric Brian Dumbledore");

        String expectedFirst = "Albus";
        String expectedMiddle = "Percival Wulfric Brian";
        String expectedLast = "Dumbledore";

        assertEquals(expectedFirst, s.getFirstName());
        assertEquals(expectedMiddle, s.getMiddleName());
        assertEquals(expectedLast, s.getLastName());
    }

    @Test
    void setFullNameWithEmptyString(){
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFullName("");

        assertNull(s.getFirstName());
        assertNull(s.getMiddleName());
        assertNull(s.getLastName());
    }

    @Test
    void setFullNameWithNull(){
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFullName(null);

        assertNull(s.getFirstName());
        assertNull(s.getMiddleName());
        assertNull(s.getLastName());
    }

    @Test
    void capitalizeIndividualNames(){
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFirstName("harry");
        s.setMiddleName("james");
        s.setLastName("potter");

        String expectedFirst = "Harry";
        String expectedMiddle = "James";
        String expectedLast = "Potter";

        assertEquals(expectedFirst, s.getFirstName());
        assertEquals(expectedMiddle, s.getMiddleName());
        assertEquals(expectedLast, s.getLastName());
    }

    @Test
    void capitalizeIndividualNamesWithCrazyCapitalization(){
        Student s = new Student("first", "middle", "last", "gender", null, false,5);

        s.setFirstName("hARrY");
        s.setMiddleName("jaMeS");
        s.setLastName("poTtEr");

        String expectedFirst = "Harry";
        String expectedMiddle = "James";
        String expectedLast = "Potter";

        assertEquals(expectedFirst, s.getFirstName());
        assertEquals(expectedMiddle, s.getMiddleName());
        assertEquals(expectedLast, s.getLastName());
    }
}