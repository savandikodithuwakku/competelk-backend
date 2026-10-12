package lk.competelk.competelk_backend.repository;

import lk.competelk.competelk_backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}