package ua.opnu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> isPrime = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        };
        System.out.println(isPrime.test(7));
        System.out.println(isPrime.test(10));

        Student[] students = {
                new Student("Ivan", "Petrenko", "KN-1", new int[]{90, 95, 100}),
                new Student("Petro", "Koval", "KN-1", new int[]{55, 60, 65}),
                new Student("Olga", "Sidorova", "KN-2", new int[]{90, 90, 90})
        };

        Predicate<Student> hasDebt = s -> {
            for (int mark : s.getMarks()) {
                if (mark < 60) return true;
            }
            return false;
        };

        Student[] debtors = filterStudents(students, hasDebt);
        System.out.println(Arrays.toString(debtors));

        int[] numbers = {5, 12, 15, 20, 25, 30};
        Predicate<Integer> gt10 = n -> n > 10;
        Predicate<Integer> div3 = n -> n % 3 == 0;
        int[] filteredNumbers = filterByTwoConditions(numbers, gt10, div3);
        System.out.println(Arrays.toString(filteredNumbers));

        Consumer<Student> printName = s -> System.out.println(s.getSurname() + " " + s.getName());
        forEachStudent(students, printName);

        int[] intArr = {1, 2, 3, 4, 5, 6};
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Consumer<Integer> printSquare = n -> System.out.println(n * n);
        processPredicateConsumer(intArr, isEven, printSquare);

        Function<Integer, Integer> powerOfTwo = n -> (int) Math.pow(2, n);
        int[] inputs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] powers = applyFunction(inputs, powerOfTwo);
        System.out.println(Arrays.toString(powers));

        Function<Integer, String> toWord = n -> {
            String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
            if (n >= 0 && n < words.length) return words[n];
            return "unknown";
        };
        String[] stringified = stringify(inputs, toWord);
        System.out.println(Arrays.toString(stringified));
    }

    public static Student[] filterStudents(Student[] input, Predicate<Student> p) {
        Student[] result = new Student[input.length];
        int count = 0;
        for (Student s : input) {
            if (p.test(s)) {
                result[count++] = s;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public static int[] filterByTwoConditions(int[] input, Predicate<Integer> p1, Predicate<Integer> p2) {
        int[] result = new int[input.length];
        int count = 0;
        for (int i : input) {
            if (p1.test(i) && p2.test(i)) {
                result[count++] = i;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    public static void forEachStudent(Student[] input, Consumer<Student> action) {
        for (Student s : input) {
            action.accept(s);
        }
    }

    public static void processPredicateConsumer(int[] input, Predicate<Integer> p, Consumer<Integer> c) {
        for (int i : input) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
    }

    public static int[] applyFunction(int[] input, Function<Integer, Integer> f) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = f.apply(input[i]);
        }
        return result;
    }

    public static String[] stringify(int[] input, Function<Integer, String> f) {
        String[] result = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = f.apply(input[i]);
        }
        return result;
    }
}