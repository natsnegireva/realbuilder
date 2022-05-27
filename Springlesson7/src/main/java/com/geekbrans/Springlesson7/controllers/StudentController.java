package com.geekbrans.Springlesson7.controllers;

import com.geekbrans.Springlesson7.models.Students;
import com.geekbrans.Springlesson7.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Students> showAll() {
        return studentService.showAll();
    }

    @GetMapping("/{id}")
    public Students findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Students saveNewStudent(@RequestBody Students student) {
        student.setId(null);
        return studentService.saveOrUpdate(student);
    }

    @PutMapping
    public Students updateStudent(@RequestBody Students student) {
        return studentService.saveOrUpdate(student);
    }
}
