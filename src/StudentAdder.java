package studentdatabase;

public class StudentAdder {
    private Student[] students;
    private int count;
    private int capacity;

    public StudentAdder(Student[] students, int count, int capacity) {
        this.students = students;
        this.count = count;
        this.capacity = capacity;
    }

    public int addStudent(Student student) throws DuplicateStudentException, DatabaseFullException {
        if (count >= capacity) {
            throw new DatabaseFullException("Database is full. Cannot add more students.");
        }

        for (int i = 0; i < count; i++) {
            if (students[i].getPrn().equals(student.getPrn())) {
                throw new DuplicateStudentException("Student with PRN " + student.getPrn() + " already exists.");
            }
        }

        students[count] = student;
        return count + 1;
    }
}