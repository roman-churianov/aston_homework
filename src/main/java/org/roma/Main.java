package org.roma;


import org.roma.faculty.Faculty;
import org.roma.faculty.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void testStudentAGP() {
        Student s2 = new Student("Mark", "8", 3);
        s2.setMarks(new ArrayList<>(Arrays.asList(1, 2, 1)));
        Student s3 = new Student("Jim", "4", 1);
        s3.setMarks(new ArrayList<>(Arrays.asList(4, 5, 4)));

        System.out.println("Student " + s2.getName() + " AGP: " + s2.getAGP());
        System.out.println("Student " + s3.getName() + " AGP: " + s3.getAGP());
        System.out.println();
    }

    public static void testRemoveStudent() {
        Student s1 = new Student("Tom", "7", 2);
        s1.setMarks(new ArrayList<Integer>(Arrays.asList(2, 2, 2)));
        Student s2 = new Student("Mark", "8", 3);
        s2.setMarks(new ArrayList<>(Arrays.asList(1, 2, 1)));
        Student s3 = new Student("Jim", "4", 1);
        s3.setMarks(new ArrayList<>(Arrays.asList(4, 5, 4)));

        Faculty faculty = new Faculty();
        faculty.addStudent(s1);
        faculty.addStudent(s2);
        faculty.addStudent(s3);

        faculty.printAllStudents();

        faculty.removeStudentsWithAGPLessThenThree();
        System.out.println("Removed students with AGP < 3. Student list after removal: ");
        faculty.printAllStudents();
    }

    public static void testTransferStudents() {
        Student s1 = new Student("Tom", "7", 2);
        s1.setMarks(new ArrayList<Integer>(Arrays.asList(2, 2, 2)));
        Student s2 = new Student("Mark", "8", 3);
        s2.setMarks(new ArrayList<>(Arrays.asList(1, 2, 1)));
        Student s3 = new Student("Jim", "4", 1);
        s3.setMarks(new ArrayList<>(Arrays.asList(4, 5, 4)));

        Faculty faculty = new Faculty();
        faculty.addStudent(s1);
        faculty.addStudent(s2);
        faculty.addStudent(s3);

        faculty.transferStudents();
        faculty.printAllStudents();
    }

    public static void main(String[] args) {
        System.out.println("Testing Student AGP");
        testStudentAGP();

        System.out.println("Testing removing students from faculty");
        testRemoveStudent();

        System.out.println("Testing transfer students to the next course");
        testTransferStudents();
    }
}