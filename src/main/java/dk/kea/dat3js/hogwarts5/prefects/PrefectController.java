package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.StudentRequestDTO;
import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prefects")
public class PrefectController {

    private final PrefectService prefectService;

    public PrefectController(PrefectService prefectService) {
        this.prefectService = prefectService;
    }

    @GetMapping
    public List<StudentResponseDTO> getPrefects() {
        return prefectService.findAll();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponseDTO> getPrefectByStudentId(@PathVariable int studentId) {
        return ResponseEntity.of(prefectService.findByStudentId(studentId));
    }

    @GetMapping("/house/{houseName}")
    public ResponseEntity<StudentResponseDTO> getPrefectsByHouseName(@PathVariable String houseName) {
        return ResponseEntity.of(prefectService.findAllByHouseName(houseName));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> setPrefect(@RequestBody StudentRequestDTO request){
        return ResponseEntity.of(prefectService.makePrefect(request));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentResponseDTO> removePrefectByStudentId(@PathVariable int studentId) {
        return ResponseEntity.of(prefectService.deleteByStudentId(studentId));
    }

}
