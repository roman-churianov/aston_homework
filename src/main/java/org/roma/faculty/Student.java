package org.roma.faculty;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> marks;

    public Student() {
        marks = new ArrayList<>();
    }

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = new ArrayList<>();
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>(marks);
    }

    public void addMark(int mark) {
        this.marks.add(mark);
    }

    public void addMarks(List<Integer> marks) {
        this.marks.addAll(marks);
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public double getAGP() {
        double agp = 0.0;
        for (Integer i : marks) {
            agp += i;
        }
        agp = agp / (double)marks.size();
        return agp;
    }

    public void increaseCourse() {
        course += 1;
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Student name: " + name);
        System.out.println("Group: " + group);
        System.out.println("Course: " + course);
        System.out.print("Marks: ");
        for (Integer t : marks) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
