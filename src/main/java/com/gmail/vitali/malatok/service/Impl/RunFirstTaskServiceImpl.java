package com.gmail.vitali.malatok.service.Impl;

import com.gmail.vitali.malatok.model.Student;
import com.gmail.vitali.malatok.service.RunFirstTaskService;

import java.util.*;

import static com.gmail.vitali.malatok.model.StudentManager.*;

public class RunFirstTaskServiceImpl implements RunFirstTaskService {
    @Override
    public void runFirstTask() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice Montana", "A1", 1, List.of(3, 4, 5)));
        students.add(new Student("Alice Grengo", "A1", 1, List.of(3, 2, 1)));
        students.add(new Student("Alice Perlo", "B2", 2, List.of(3, 4, 5)));
        students.add(new Student("Alice Fredry", "B2", 2, List.of(3, 3, 2)));
        students.add(new Student("Bob Garlik", "C1", 3, List.of(2, 2, 3)));
        students.add(new Student("Charlie Werstom", "C1", 3, List.of(4, 5, 5)));

        System.out.println("Список студентов до удаления:");
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);

        removeLowPerformingStudents(students);
        promoteStudents(students);

        System.out.println("\nСписок студентов после удаления и перевода:");
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
        printStudents(students, 4);
    }
}
