package org.skypro._9999.repository;

import org.skypro._9999.obj.Faculty;
import org.skypro._9999.obj.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Collection<Student> findByAgeBetween(int one , int two);

    public Collection<Student> findAllStudentsByFacultyStudentIgnoreCaseContains(String nameFaculty);

}
