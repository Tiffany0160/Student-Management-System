package Student;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int mark;

    Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }


    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- STUDENT MANAGEMENT ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateMarks();
                case 4 -> calculateAverage();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter mark: ");
        int mark = sc.nextInt();

        students.add(new Student(name, mark));
        System.out.println("Student added.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).name + " - " + students.get(i).mark);
        }
    }

    static void updateMarks() {
        viewStudents();
        System.out.print("Select student number: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < students.size()) {
            System.out.print("Enter new mark: ");
            students.get(index).mark = sc.nextInt();
            System.out.println("Mark updated.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No data.");
            return;
        }

        int total = 0;
        for (Student s : students) {
            total += s.mark;
        }

        System.out.println("Average mark: " + (total / students.size()));
    }
}
