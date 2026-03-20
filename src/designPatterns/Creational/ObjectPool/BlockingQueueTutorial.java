package designPatterns.Creational.ObjectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class BlockingQueueTutorial {
    public static void main(String[] args) {
        // Shared queue with a capacity of 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Producer Thread
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producing: " + i);
                    queue.put(i); // Blocks if the queue is full
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }).start();

        // Consumer Thread
        new Thread(() -> {
            try {
                while (true) {
                    Integer task = queue.take(); // Blocks if the queue is empty
                    System.out.println("Consumed: " + task);
                    Thread.sleep(1000); // Slower consumer
                }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }).start();
    }
}
