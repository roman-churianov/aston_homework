package org.roma;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Faculty {
    private List<Student> students;

    public void removeStudentsWithAGPLessThenThree() {
        int i = 0;
        List<Integer> studentIndicesToRemove = new ArrayList<>();
        for (Student s : students) {
            if (s.getAGP() < 3) {
                studentIndicesToRemove.add(i);
            }
            ++i;
        }
        for (Integer j : studentIndicesToRemove) {
            students.remove(j);
        }
    }

    public void transferStudents() {
        for (Student s : students) {
            if (s.getAGP() >= 3) {
                s.increaseCourse();
            }
        }
    }

    public void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}
