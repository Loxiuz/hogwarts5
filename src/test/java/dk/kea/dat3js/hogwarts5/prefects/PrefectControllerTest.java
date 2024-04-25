package dk.kea.dat3js.hogwarts5.prefects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PrefectControllerTest {

    @Mock
    PrefectService prefectService;

    @InjectMocks
    PrefectController prefectController;

    @Test
    void getPrefects() {
    }

    @Test
    void getPrefectByStudentId() {
    }

    @Test
    void getPrefectsByHouseName() {
    }

    @Test
    void setPrefect() {
    }

    @Test
    void removePrefectByStudentId() {
    }

}