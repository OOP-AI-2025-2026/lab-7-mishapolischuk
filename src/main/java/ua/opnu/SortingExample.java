package ua.opnu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", "Petrenko", "KN-1", new int[]{4, 5, 4}));
        students.add(new Student("Anna", "Shevchenko", "KN-1", new int[]{5, 5, 5}));
        students.add(new Student("Boris", "Bondar", "KN-2", new int[]{3, 4, 3}));

        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println(students);

        students.sort((s1, s2) -> s1.getSurname().compareTo(s2.getSurname()));
        System.out.println(students);

        students.sort((s1, s2) -> {
            double avg1 = Arrays.stream(s1.getMarks()).average().orElse(0);
            double avg2 = Arrays.stream(s2.getMarks()).average().orElse(0);
            return Double.compare(avg1, avg2);
        });
        System.out.println(students);
    }
}