package studentdatabase;

import java.util.Arrays;

public class StudentSearcher {
    private Student[] students;
    private int count;

    public StudentSearcher(Student[] students, int count) {
        this.students = students;
        this.count = count;
    }

    public Student searchByPRN(String prn) throws StudentNotFoundException, InvalidPRNException {
        if (prn == null || prn.trim().isEmpty()) {
            throw new InvalidPRNException("PRN cannot be empty.");
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getPrn().equals(prn)) {
                return students[i];
            }
        }

        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    public Student[] searchByName(String name) throws StudentNotFoundException {
        Student[] temp = new Student[count];
        int found = 0;

        for (int i = 0; i < count; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                temp[found++] = students[i];
            }
        }

        if (found == 0) {
            throw new StudentNotFoundException("No students found with name " + name);
        }

        return Arrays.copyOf(temp, found);
    }

    public Student searchByPosition(int position) throws InvalidPositionException {
        if (position < 1 || position > count) {
            throw new InvalidPositionException("Invalid position. Must be between 1 and " + count);
        }
        return students[position - 1];
    }
}
