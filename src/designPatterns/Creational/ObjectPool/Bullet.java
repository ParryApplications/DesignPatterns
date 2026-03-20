package designPatterns.Creational.ObjectPool;

public interface Bullet extends Poolable {
    void setBulletSpeed(int kmPerHr);
    int getBulletSpeed();
}
