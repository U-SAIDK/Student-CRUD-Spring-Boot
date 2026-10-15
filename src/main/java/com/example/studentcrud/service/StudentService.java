
package com.example.studentcrud.service;

import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student student = getStudentById(id);

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());
        student.setCourse(updatedStudent.getCourse());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
