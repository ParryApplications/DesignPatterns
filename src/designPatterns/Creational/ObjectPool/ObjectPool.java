package designPatterns.Creational.ObjectPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ObjectPool<T extends Poolable> {

    private BlockingQueue<T> cache;

    public ObjectPool(Supplier<T> supplier, int numberOfBullets) {
        cache = new ArrayBlockingQueue<>(numberOfBullets);
        IntStream.range(0, numberOfBullets).forEach((i) -> {
            cache.offer(supplier.get());
        });
    }

    //Either we can wait until cache has available object or we can create new one (but make sure to trim the pool).
    //Here i am going with waiting until we got the available object.
    public T get() {
        try {
            return cache.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Must call reset()
    public void release(T obj) {
        obj.reset();
        try {
            cache.put(obj);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
