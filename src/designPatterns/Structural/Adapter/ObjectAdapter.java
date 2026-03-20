package designPatterns.Structural.Adapter;

public class ObjectAdapter implements User {

    //Composition:
    private Student student;//Has a Relation

    public ObjectAdapter(Student student) {
        this.student = student;
    }

    @Override
    public String getName() {
        return student.getStudentName();
    }

    @Override
    public int getRollNumber() {
        return student.getStudentEnrollmentNumber();
    }
}
