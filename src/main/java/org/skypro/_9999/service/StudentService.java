package org.skypro._9999.service;

import org.skypro._9999.obj.Student;
import org.skypro._9999.repository.StudentRepository;
import org.springframework.stereotype.Service;

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

    /*public Collection<Student> findByAge(int age) {
        ArrayList<Student> result = new ArrayList();
        for (Student student : students.values()) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }*/
}

