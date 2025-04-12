package studentdatabase;

public class StudentUpdater {
    private Student[] students;
    private int count;

    public StudentUpdater(Student[] students, int count) {
        this.students = students;
        this.count = count;
    }

    public void updateStudent(String prn, Student newStudent) throws StudentNotFoundException {
        for (int i = 0; i < count; i++) {
            if (students[i].getPrn().equals(prn)) {
                students[i] = newStudent;
                return;
            }
        }
        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }
}
