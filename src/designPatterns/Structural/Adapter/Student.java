package designPatterns.Structural.Adapter;

public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int enroll) {
        this.name = name;
        this.rollNumber = enroll;
    }

    String getStudentName() {
        return this.name;
    }

    int getStudentEnrollmentNumber() {
        return this.rollNumber;
    }
}
