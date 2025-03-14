package com.gmail.vitali.malatok.model;

import java.util.List;

public class StudentManager {
    public static void removeLowPerformingStudents(List<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < 3) {
                students.remove(i);
                i--;
            }
        }
    }

    public static void promoteStudents(List<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.course++;
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name + " \\ course: " + student.course);
            }
        }
    }
}
