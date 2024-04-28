package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.house.HouseRepository;
import dk.kea.dat3js.hogwarts5.students.StudentRepository;
import dk.kea.dat3js.hogwarts5.students.StudentRequestDTO;
import dk.kea.dat3js.hogwarts5.students.StudentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PrefectService {

    private final StudentRepository studentRepository;
    private final HouseRepository houseRepository;

    public PrefectService(StudentRepository studentRepository , HouseRepository houseRepository) {
        this.studentRepository = studentRepository;
        this.houseRepository = houseRepository;
    }

    public List<StudentResponseDTO> findAll(){return Collections.emptyList();}

    public Optional<StudentResponseDTO> findByStudentId(int studentId){
        return Optional.empty();
    }

    public Optional<StudentResponseDTO> findAllByHouseName(String houseName){
        return Optional.empty();
    }

    public Optional<StudentResponseDTO> makePrefect(StudentRequestDTO request){
        return Optional.of(new StudentResponseDTO(0, "", "", "","", "", "", false,0));
    }

    public Optional<StudentResponseDTO> deleteByStudentId(int studentId){
        return Optional.empty();
    }

}
