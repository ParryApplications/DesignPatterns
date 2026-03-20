package designPatterns.Behavioral.Visitor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Client {
    public static void main(String[] args) {
        Objects bookObj = new Book();
        Objects fruitObj = new Fruit();

        Visitor Op1 = new Operation1();
//        Visitor Op2 = new Operation2();
//        Visitor Op3 = new Operation3();
        bookObj.accept(Op1);//Object accepts visitor's operation 1
        fruitObj.accept(Op1);
    }

}
