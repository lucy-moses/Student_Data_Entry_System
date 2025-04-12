/*
Name: Ugwuaneke lucy ifeoma
PRN: 23070126169
Batch: AIML B2
*/
package studentdatabase;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDatabase database;

    public static void main(String[] args) {
        System.out.println("Student Data Entry System");
        System.out.print("Enter maximum number of students: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline
        database = new StudentDatabase(capacity);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: database.getDisplayer().displayAllStudents(); break;
                    case 3: searchStudent(); break;
                    case 4: updateStudent(); break;
                    case 5: deleteStudent(); break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addStudent() {
        System.out.println("\nAdd New Student");
        System.out.print("Enter PRN: ");
        String prn = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        try {
            if (marks < 0 || marks > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }
            Student student = new Student(prn, name, dob, marks);
            int newCount = database.getAdder().addStudent(student);
            database.setCount(newCount);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Cannot add student: " + e.getMessage());
        }
    }

    private static void searchStudent() {
        System.out.println("\nSearch Student");
        System.out.println("1. By PRN");
        System.out.println("2. By Name");
        System.out.println("3. By Position");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (searchChoice) {
                case 1:
                    System.out.print("Enter PRN to search: ");
                    String prn = scanner.nextLine();
                    Student s = database.getSearcher().searchByPRN(prn);
                    System.out.println("Student found: " + s);
                    break;
                case 2:
                    System.out.print("Enter Name to search: ");
                    String name = scanner.nextLine();
                    Student[] students = database.getSearcher().searchByName(name);
                    System.out.println("Found " + students.length + " student(s):");
                    for (Student st : students) {
                        System.out.println(st);
                    }
                    break;
                case 3:
                    System.out.print("Enter position to search (1-" + database.getCount() + "): ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    Student st = database.getSearcher().searchByPosition(pos);
                    System.out.println("Student at position " + pos + ": " + st);
                    break;
                default:
                    System.out.println("Invalid search choice.");
            }
        } catch (Exception e) {
            System.out.println("Search error: " + e.getMessage());
        }
    }

    private static void updateStudent() {
        System.out.println("\nUpdate Student");
        System.out.print("Enter PRN of student to update: ");
        String prn = scanner.nextLine();

        try {
            Student oldStudent = database.getSearcher().searchByPRN(prn);
            System.out.println("Current details: " + oldStudent);

            System.out.print("Enter new PRN (leave blank to keep current): ");
            String newPrn = scanner.nextLine();
            System.out.print("Enter new Name (leave blank to keep current): ");
            String newName = scanner.nextLine();
            System.out.print("Enter new DoB (leave blank to keep current): ");
            String newDob = scanner.nextLine();
            System.out.print("Enter new Marks (enter -1 to keep current): ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine();

            if (newPrn.isEmpty()) newPrn = oldStudent.getPrn();
            if (newName.isEmpty()) newName = oldStudent.getName();
            if (newDob.isEmpty()) newDob = oldStudent.getDob();
            if (newMarks == -1) newMarks = oldStudent.getMarks();

            if (newMarks < 0 || newMarks > 100) {
                throw new InvalidMarkException("Marks must be between 0 and 100");
            }

            Student updatedStudent = new Student(newPrn, newName, newDob, newMarks);
            database.getUpdater().updateStudent(prn, updatedStudent);
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            System.out.println("Cannot update student: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.println("\nDelete Student");
        System.out.print("Enter PRN of student to delete: ");
        String prn = scanner.nextLine();

        try {
            int newCount = database.getDeleter().deleteStudent(prn);
            database.setCount(newCount);
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            System.out.println("Cannot delete student: " + e.getMessage());
        }
    }
}