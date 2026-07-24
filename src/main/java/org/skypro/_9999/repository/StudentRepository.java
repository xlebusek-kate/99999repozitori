package org.skypro._9999.repository;

import org.skypro._9999.obj.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
