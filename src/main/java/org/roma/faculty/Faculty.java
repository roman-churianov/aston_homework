package org.roma.faculty;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/*
* Class for holding Student collection
* */

public class Faculty {
    private Map<Integer, Student> students;
    private Integer idCounter;

    public Faculty() {
        students = new HashMap<>();
        idCounter = 0;
    }

    public void addStudent(Student newStudent) {
        students.put(idCounter, newStudent);
        idCounter++;
    }

    public void removeStudentsWithAGPLessThenThree() {
        students.entrySet().removeIf(entry -> entry.getValue().getAGP() < 3);
    }

    public void transferStudents() {
        for (Map.Entry<Integer, Student> s : students.entrySet()) {
            if (s.getValue().getAGP() >= 3) {
                s.getValue().increaseCourse();
            }
        }
    }

    public static void printStudentsOnCourse(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }

    public void printAllStudents() {
        for (Map.Entry<Integer, Student> s : students.entrySet()) {
            s.getValue().print();
            System.out.println();
        }
    }
}
