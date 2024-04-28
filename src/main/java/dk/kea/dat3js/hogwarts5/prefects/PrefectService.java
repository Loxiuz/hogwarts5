package dk.kea.dat3js.hogwarts5.prefects;

import dk.kea.dat3js.hogwarts5.students.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrefectService {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public PrefectService(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }

    public List<StudentResponseDTO> findAll(){
        List<Student> students = studentRepository.findAllPrefect();
        return students.stream().map(studentService::toDTO).toList();
    }

    public Optional<StudentResponseDTO> findByStudentId(int studentId){
        return Optional.of(studentService.toDTO(studentRepository.findPrefectByStudentId(studentId)));
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
