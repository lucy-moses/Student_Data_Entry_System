package studentdatabase;

public class StudentDisplayer {
    private Student[] students;
    private int count;

    public StudentDisplayer(Student[] students, int count) {
        this.students = students;
        this.count = count;
    }

    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No students in the database.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + students[i]);
        }
    }
}
