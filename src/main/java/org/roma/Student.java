package org.roma;

import java.util.List;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> marks;

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
}
