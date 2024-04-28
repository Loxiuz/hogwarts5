package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.house.HouseRepository;
import dk.kea.dat3js.hogwarts5.house.HouseService;
import dk.kea.dat3js.hogwarts5.students.Student;
import dk.kea.dat3js.hogwarts5.students.StudentRepository;
import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import dk.kea.dat3js.hogwarts5.students.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class PrefectServiceTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    HouseService houseService;

    @Mock
    StudentService studentService;

    @InjectMocks
    PrefectService prefectService;

    @BeforeEach
    void setUp() {
        Student harry = new Student("Harry", "James", "Potter", "male", null, true, 5);
        Student hermione = new Student("Hermione", "Jean", "Granger", "female", null, true, 5);
        Student ron = new Student("Ron", "Bilius", "Weasley", "male", null, false, 5);

        Student draco = new Student("Draco", "", "Malfoy", "male", null, true, 5);
        Student pansy = new Student("Pansy", "", "Parkinson", "female", null, true, 5);
        Student blaise = new Student("Blaise", "", "Zabini", "male", null, false, 5);

        Student cedric = new Student("Cedric", "", "Diggory", "male", null, true, 6);
        Student hannah = new Student("Hannah", "", "Abbott", "female", null, true, 5);
        Student justin = new Student("Justin", "", "Finch-Fletchley", "male", null, false, 5);

        Student michael = new Student("Michael", "", "Corner", "male", null, true, 5);
        Student cho = new Student("Cho", "", "Chang", "female", null, true, 6);
        Student padma = new Student("Padma", "", "Patil", "female", null, false, 5);

        studentRepository.save(harry);
        studentRepository.save(hermione);
        studentRepository.save(ron);
        studentRepository.save(draco);
        studentRepository.save(pansy);
        studentRepository.save(blaise);
        studentRepository.save(cedric);
        studentRepository.save(hannah);
        studentRepository.save(justin);
        studentRepository.save(michael);
        studentRepository.save(cho);
        studentRepository.save(padma);

        studentService = new StudentService(studentRepository, houseService);
        prefectService = new PrefectService(studentRepository, studentService);
    }

    @Test
    void findAll() {
        List<StudentResponseDTO> prefectStudents = prefectService.findAll();
        assertEquals(12, prefectStudents.size());
    }

    @Test
    void findByStudentId() {
        Optional<StudentResponseDTO> student = prefectService.findByStudentId(2);
        assertTrue(student.isPresent());
        assertEquals("Hermione Jean Granger", student.get().fullName());
    }

    @Test
    void findAllByHouseName() {
    }

    @Test
    void makePrefect() {
    }

    @Test
    void deleteByStudentId() {
    }

}