package com.geekbrains.realbuilder.hibernate5.services;

import com.geekbrains.realbuilder.hibernate5.model.Students;
import com.geekbrains.realbuilder.hibernate5.repository.StudentRepository;
import com.geekbrains.realbuilder.hibernate5.utils.HibernateUtil;
import com.mysql.cj.jdbc.exceptions.OperationNotSupportedException;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentRepository studentRepository;
    private final SessionFactory factory;

    public StudentService(StudentRepository studentRepository, SessionFactory factory) {
        this.studentRepository = studentRepository;
        this.factory = factory;
    }

    public void printTotalCount() {
        System.out.println("Количество записей в БД: " + studentRepository.countAll());
    }

    public Students findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Students> findAllStudents(){
        return studentRepository.findAll();
    }

    public void printAllStudents(){
        System.out.println("Полный список студентов:");
        studentRepository.findAll().forEach(System.out::println);
    }

    public void addStudents(List<Students> studentsList) {
        System.out.println("Добавление новых записей: " + studentsList.size());
        studentRepository.mergeBatch(studentsList);
    }

    public void removeAllStudents() {
        System.out.println("Очистка таблицы (удаление всех записей)");
        studentRepository.removeAll();
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public Students renameStudent(Long id, String newName){

        if (studentRepository.countAll() == 0) return null;
        Students students = studentRepository.findById(id);
        if (students != null) {
            students.setName(newName);
            studentRepository.merge(students);
            return students;
        }
        return null;
    }

}
