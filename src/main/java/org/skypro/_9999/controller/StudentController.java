package org.skypro._9999.controller;

import org.skypro._9999.obj.Faculty;
import org.skypro._9999.obj.Student;
import org.skypro._9999.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/info/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudent(id).orElseThrow(()-> new RuntimeException("Не найдено")));
    }

    @GetMapping("/faculty/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable long id) {
        return ResponseEntity.ok(studentService.getFaculty(id));
    }

    @GetMapping("/findByAge")
    public ResponseEntity<Collection<Student>> findByAge(@RequestParam int min, @RequestParam int max) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findByAge(min, max));
    }

    @GetMapping("/by-faculty")
    public ResponseEntity<Collection<Student>> getStudentsOneFaculty(@RequestParam String nameFaculty){
        return ResponseEntity.ok(studentService.getStudentsOneFaculty(nameFaculty));
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.addStudent(student));
    }

    @PutMapping("/put")
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.editStudent(student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}
