package designPatterns.Creational.ObjectPool;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Caller {
    static int numberOfBulletsShoot = 10;
    private static final ObjectPool<Bullet> OBJECT_POOL = new ObjectPool<>(BullerImpl::new, numberOfBulletsShoot);

    public static void main(String[] args) {
        System.out.println("=== Bullet Firing Simulation ===");
        System.out.println("Max bullets: " + numberOfBulletsShoot);
        System.out.println("Firing interval: 1 second");
        System.out.println("================================\n");

        long startTime = System.currentTimeMillis();
        AtomicInteger bulletCounter = new AtomicInteger(0);

        new Thread(() -> {
            for (int i = 0; i < numberOfBulletsShoot; i++) {
                try {
                    // Get bullet from pool
                    Bullet bullet = OBJECT_POOL.get();
                    int bulletNumber = bulletCounter.incrementAndGet();
                    int speed = new Random().nextInt(1000) + 1; // Speed between 1-1000 km/h
                    bullet.setBulletSpeed(speed);

                    // Calculate elapsed time
                    long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;

                    // Log bullet firing
                    System.out.println("🔫 Firing bullet #" + bulletNumber +
                            " with speed " + speed + " km/h at " +
                            elapsedSeconds + "s");

                    // Simulate bullet in flight (release after some time)
                    final int finalBulletNumber = bulletNumber;
                    new Thread(() -> {
                        try {
                            // Simulate bullet flight time (500ms)
                            Thread.sleep(500);
                            OBJECT_POOL.release(bullet);
                            System.out.println("   ↩️  Bullet #" + finalBulletNumber + " returned to pool");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.err.println("Bullet release interrupted: " + e.getMessage());
                        }
                    }).start();

                    // Wait 1 second before firing next bullet (except for the last one)
                    if (i < numberOfBulletsShoot - 1) {
                        Thread.sleep(1000);
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Bullet firing interrupted: " + e.getMessage());
                    break;
                }
            }

            System.out.println("\n================================");
            System.out.println("All " + bulletCounter.get() + " bullets fired!");
            System.out.println("================================");
        }).start();
    }

}
