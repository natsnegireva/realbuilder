package com.geekbrans.Springlesson7.services;

import com.geekbrans.Springlesson7.models.Students;
import com.geekbrans.Springlesson7.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Students findById(Long id) {
        Students student = studentRepository.findById(id).get();
        return student;
    }

    public List<Students> showAll() {
        return new ArrayList<>(studentRepository.findAll());
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Students saveOrUpdate(Students student) {
        Students entity = null;
        if (student.getId() != null) {
            entity = studentRepository.findById(student.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Student with id " + student.getId() + " doesn't exist!"));
        } else {
            entity = studentRepository.save(new Students(student.getName(), student.getAge()));
        }
        return entity;
    }
}
