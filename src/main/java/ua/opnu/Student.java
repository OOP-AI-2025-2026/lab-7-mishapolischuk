package ua.opnu;

import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private String group;
    private int[] marks;

    public Student(String name, String surname, String group, int[] marks) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + group + " " + Arrays.toString(marks);
    }
}