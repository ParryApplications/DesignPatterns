package designPatterns.Structural.Adapter;

public class Client {
    public static void main(String[] args) {
        //Create User object
        Student student = new Student("Paras", 202115104);
        ObjectAdapter objectAdapter = new ObjectAdapter(student);
        entry(objectAdapter);
    }

    public static void entry(User user) {
        System.out.println(user.getName());
        System.out.println(user.getRollNumber());
    }
}
