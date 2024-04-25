package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.house.HouseRepository;
import dk.kea.dat3js.hogwarts5.students.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PrefectServiceTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    HouseRepository houseRepository;

    @InjectMocks
    PrefectService prefectService;

    @Test
    void findAll() { //Prioritize
    }

    @Test
    void findByStudentId() { //Prioritize
    }

    @Test
    void findStudentByIdWithNull() {
    }

    @Test
    void findStudentByIdWithZero() {
    }

    @Test
    void findStudentByIdWithNegativeInteger() {
    }

    @Test
    void findAllByHouseName() { //Prioritize
    }

    @Test
    void findAllByHouseNameWithNull() {
    }

    @Test
    void findAllByHouseNameWithEmptyString() {
    }

    @Test
    void makePrefect() { //Prioritize
    }

    @Test
    void makePrefectWithNull() {
    }

    @Test
    void makePrefectWithEmptyRequestBody() {
    }

    @Test
    void deleteByStudentId() { //Prioritize
    }

    @Test
    void deleteByStudentIdWithNull() {
    }

    @Test
    void deleteByStudentIdWithZero() {
    }

    @Test
    void deleteByStudentIdWithNegativeInteger() {
    }
}