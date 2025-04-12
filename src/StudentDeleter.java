package studentdatabase;

public class StudentDeleter {
    private Student[] students;
    private int count;

    public StudentDeleter(Student[] students, int count) {
        this.students = students;
        this.count = count;
    }

    public int deleteStudent(String prn) throws StudentNotFoundException {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getPrn().equals(prn)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
        }

        // Shift elements to left
        for (int i = index; i < count - 1; i++) {
            students[i] = students[i + 1];
        }
        students[--count] = null;
        return count;
    }
}