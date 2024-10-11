package com.saksham.demo.rest;

import com.saksham.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        System.out.println("Creating Students");
        this.students = new ArrayList<>();
        this.students.add(new Student("Poornima", "Patel"));
        this.students.add(new Student("Mario", "Rossi"));
        this.students.add(new Student("Mary", "Smith"));
    }


    // define endpoint for "/students" - returns list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {

        if(studentId < 0 || studentId >= this.students.size()) {
            throw new StudentNotFoundException("Student not present for studentId: " + studentId);
        }
        return this.students.get(studentId);
    }
}
