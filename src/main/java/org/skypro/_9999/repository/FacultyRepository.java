package org.skypro._9999.repository;

import org.skypro._9999.obj.Faculty;
import org.skypro._9999.obj.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty , Long> {

    public Faculty findByNameContainingIgnoreCaseOrColorContainingIgnoreCase(String name , String color);

    public Collection<Student> findAllStudentsByFacultyStudentIgnoreCaseContains(String nameFaculty);

}
