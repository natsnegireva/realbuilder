package com.geekbrains.realbuilder.hibernate5;

import com.geekbrains.realbuilder.hibernate5.model.Students;
import com.geekbrains.realbuilder.hibernate5.repository.StudentRepository;
import com.geekbrains.realbuilder.hibernate5.repository.StudentRepositoryImpl;
import com.geekbrains.realbuilder.hibernate5.services.StudentService;
import com.geekbrains.realbuilder.hibernate5.utils.HibernateUtil;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.internal.exception.FlywaySqlException;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AppHibernate {
    private static StudentService studentService;

    public static void main(String[] args) {
        try {
            Flyway database = Flyway.configure()
                    .dataSource("jdbc:mysql://localhost:3306/demo_hibernate", "root", "123456")
                    .load();
            database.migrate();
        } catch (FlywaySqlException e) {
            e.printStackTrace();
        } finally {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            StudentRepository studentRepository = new StudentRepositoryImpl(factory);
            studentService = new StudentService(studentRepository, factory);
            start();
        }
    }

    public static void start() {
        studentService.printTotalCount();
        System.out.println("\nСоздаем список из 1000 студентов и добавляем в БД...");
        List<Students> students = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            students.add(new Students("Student_" + "0".repeat(4 - Integer.toString(i).length()) + i, (int) (Math.random() * 10)));
        }
        studentService.addStudents(students);

        studentService.printTotalCount();
        studentService.removeAllStudents();
        studentService.printTotalCount();
        System.out.println();

        System.out.println("Создаем новый список из 10 студентов и добавляем в БД...");
        List<Students> studentsShort = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            studentsShort.add(new Students("Student_" + "0".repeat(4 - Integer.toString(i).length()) + i, (int) (Math.random() * 10)));
        }
        studentService.addStudents(studentsShort);
        studentService.printAllStudents();
        studentService.printTotalCount();
        System.out.println();

        List<Students> studentsList = studentService.findAllStudents();
        Long id = studentsList.get(2).getId();
        System.out.println("Удаление 3 записи в таблице, Student_Id = " + id);
        studentService.deleteStudentById(id);
        studentService.printAllStudents();
        studentService.printTotalCount();
        System.out.println();

        String newName = "NEW_STUDENT_0000";
        studentsList = studentService.findAllStudents();
        Students students1 = studentsList.get(studentsList.size()-2);
        System.out.println("Изменить имя предпоследнего студента в списке...");
        id = students1.getId();
        System.out.println("старое имя – " + students1.getName() + " новое имя – " + newName);
        studentService.renameStudent(id, newName);
        System.out.println(studentService.findStudentById(id));
        System.out.println();

        studentService.printAllStudents();
        studentService.printTotalCount();
        System.out.println();

        System.out.println("Удалить все записи из таблицы...");
        studentService.removeAllStudents();

        System.out.println("Закрыть фабрику HibernateUtil...");
        HibernateUtil.shutdown();
    }
}
