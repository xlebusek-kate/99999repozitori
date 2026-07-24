package org.skypro._9999.service;

import org.skypro._9999.obj.Faculty;
import org.skypro._9999.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> findFaculty(long id) {
        return facultyRepository.findById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
      return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

   // public List<Faculty> findByColor(String color) {
   //    facultyRepository.findAll();
   // }
}
