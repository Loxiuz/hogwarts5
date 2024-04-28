package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.StudentRequestDTO;
import dk.kea.dat3js.hogwarts5.students.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(PrefectController.class)
class PrefectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @BeforeEach
    void setUp() {
        StudentRequestDTO harryDTO = new StudentRequestDTO(1, "Harry", "James", "Potter", "Harry James Potter", "male", null, true, 5);
        StudentRequestDTO hermioneDTO = new StudentRequestDTO(2, "Hermione", "Jean", "Granger", "Hermione Jean Granger", "female", null, true, 5);
        StudentRequestDTO ronDTO = new StudentRequestDTO(3, "Ron", "Bilius", "Weasley", "Ron Bilius Weasley", "male", null, false, 5);

        StudentRequestDTO dracoDTO = new StudentRequestDTO(4, "Draco", "", "Malfoy", "Draco Malfoy", "male", null, true, 5);
        StudentRequestDTO pansyDTO = new StudentRequestDTO(5, "Pansy", "", "Parkinson", "Pansy Parkinson", "female", null, true, 5);
        StudentRequestDTO blaiseDTO = new StudentRequestDTO(6, "Blaise", "", "Zabini", "Blaise Zabini", "male", null, false, 5);

        StudentRequestDTO cedricDTO = new StudentRequestDTO(7, "Cedric", "", "Diggory", "Cedric Diggory", "male", null, true, 6);
        StudentRequestDTO hannahDTO = new StudentRequestDTO(8, "Hannah", "", "Abbott", "Hannah Abbott", "female", null, true, 5);
        StudentRequestDTO justinDTO = new StudentRequestDTO(9, "Justin", "", "Finch-Fletchley", "Justin Finch-Fletchley", "male", null, false, 5);

        StudentRequestDTO michaelDTO = new StudentRequestDTO(10, "Michael", "", "Corner", "Michael Corner", "male", null, true, 5);
        StudentRequestDTO choDTO = new StudentRequestDTO(11, "Cho", "", "Chang", "Cho Chang", "female", null, true, 6);
        StudentRequestDTO padmaDTO = new StudentRequestDTO(12, "Padma", "", "Patil", "Padma Patil", "female", null, false, 5);

        studentService.save(harryDTO);
        studentService.save(hermioneDTO);
        studentService.save(ronDTO);
        studentService.save(dracoDTO);
        studentService.save(pansyDTO);
        studentService.save(blaiseDTO);
        studentService.save(cedricDTO);
        studentService.save(hannahDTO);
        studentService.save(justinDTO);
        studentService.save(michaelDTO);
        studentService.save(choDTO);
        studentService.save(padmaDTO);
    }

    @Test
    void getPrefects() throws Exception {
        mockMvc.perform(get("/prefects"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(8)))
                .andExpect((ResultMatcher) jsonPath("$[*].fullName")
                        .value(containsInAnyOrder(
                            "Harry James Potter",
                            "Hermione Jean Granger",
                            "Draco Malfoy",
                            "Pansy Parkinson",
                            "Cedric Diggory",
                            "Hannah Abbott",
                            "Micheal Corner",
                            "Cho Chang"
                )));
    }

    @Test
    void getPrefectByStudentId() throws Exception {
        mockMvc.perform(get("/prefects/2"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.firstName").value("Hermione"))
                .andExpect((ResultMatcher) jsonPath("$.middleName").value("Jean"))
                .andExpect((ResultMatcher) jsonPath("$.lastName").value("Granger"));
    }

    @Test
    void getPrefectsByHouseName() throws Exception {
        mockMvc.perform(get("/prefects/house/Slytherin"))
                .andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[*].fullName")
                        .value(containsInAnyOrder(
                           "Draco Malfoy",
                           "Pansy Parkinson"
                        )));
    }

    @Test
    void setPrefect() {
    }

    @Test
    void removePrefectByStudentId() {
    }

}