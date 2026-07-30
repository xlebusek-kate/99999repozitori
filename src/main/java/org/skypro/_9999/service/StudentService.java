package org.skypro._9999.service;

import org.skypro._9999.obj.Faculty;
import org.skypro._9999.obj.Student;
import org.skypro._9999.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findStudent(long id) {
        return studentRepository.findById(id);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAge(int one , int two) {
        return studentRepository.findByAgeBetween(one,two);
    }

    public Faculty getFaculty(long idStudent){
        return studentRepository.findById(idStudent).orElseThrow(()-> new RuntimeException("Студент не найден")).getFacultyStudent();
    }

    public Collection<Student> getStudentsOneFaculty(String nameFaculty){
        return studentRepository.findAllStudentsByFacultyStudentIgnoreCaseContains(nameFaculty);
    }
}

