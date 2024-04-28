package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class StudentControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void notNull(){
        assertNotNull(webTestClient);
    }

    @Test
    void createStudentWithFullName(){
        webTestClient
                .post().uri("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("""
                    {
                    "name": "Malte Loxiuz Wontolla",
                    "gender": "male",
                    "house": "Gryffindor",
                    "prefect": false,
                    "schoolYear": 6
                    }
                    """)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CREATED)
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                    .jsonPath("$.id").exists()
                    .jsonPath("$.firstName").isEqualTo("Malte")
                    .jsonPath("$.middleName").isEqualTo("Loxiuz")
                    .jsonPath("$.lastName").isEqualTo("Wontolla")
                    .jsonPath("$.fullName").isEqualTo("Malte Loxiuz Wontolla")
                    .jsonPath("$.gender").isEqualTo("male")
                    .jsonPath("$.house").isEqualTo("Gryffindor")
                    .jsonPath("$.prefect").isEqualTo(false)
                    .jsonPath("$.schoolYear").isEqualTo(6);
    }

    @Test
    void createStudentWithNameParts(){
        webTestClient
                .post().uri("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("""
                    {
                    "firstName": "Malte",
                    "middleName": "Loxiuz",
                    "lastName": "Wontolla",
                    "gender": "male",
                    "house": "Gryffindor",
                    "prefect": false,
                    "schoolYear": 6
                    }
                    """)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CREATED)
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody().json("""
                    {
                    "firstName": "Malte",
                    "middleName": "Loxiuz",
                    "lastName": "Wontolla",
                    "fullName": "Malte Loxiuz Wontolla",
                    "gender": "male",
                    "house": "Gryffindor",
                    "prefect": false,
                    "schoolYear": 6
                    }
                    """);
    }
}
