package studentdatabase;

public class StudentDatabase {
    private Student[] students;
    private int count;
    private final int capacity;

    public StudentDatabase(int capacity) {
        this.capacity = capacity;
        this.students = new Student[capacity];
        this.count = 0;
    }

    public StudentAdder getAdder() {
        return new StudentAdder(students, count, capacity);
    }

    public StudentDisplayer getDisplayer() {
        return new StudentDisplayer(students, count);
    }

    public StudentSearcher getSearcher() {
        return new StudentSearcher(students, count);
    }

    public StudentUpdater getUpdater() {
        return new StudentUpdater(students, count);
    }

    public StudentDeleter getDeleter() {
        return new StudentDeleter(students, count);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }
}
