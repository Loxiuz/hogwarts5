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
    void findAll() {
    }

    @Test
    void findByStudentId() {
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