package designPatterns.Creational.Prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Car mercedes = new Car();
        mercedes.isManual = true;
        mercedes.drivePower();
        mercedes.accelerate();
        mercedes.brake();
        System.out.println(mercedes);

//        Car bmw = new Car();
        Car bmw = (Car) mercedes.clone();
        bmw.isElectric = true;
        System.out.println(bmw);
        System.out.println(mercedes);

    }
}
