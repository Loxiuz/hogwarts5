package dk.kea.dat3js.hogwarts5.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.prefect = true")
    List<Student> findAllPrefect();
    @Query("SELECT s FROM Student s where s.prefect = true and s.id = :studentId")
    Student findPrefectByStudentId(int studentId);
}
