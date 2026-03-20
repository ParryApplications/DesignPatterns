package designPatterns.Creational.ObjectPool;

//This interface needs to be implemented by those classes which needs to be there in the object pool, multiple classes can implement this interface
public interface Poolable {
    void reset();//Must have and call before releasing the object back to the cache (thread-safe queue)
}
