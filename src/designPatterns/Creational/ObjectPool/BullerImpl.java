package designPatterns.Creational.ObjectPool;

public class BullerImpl implements Bullet {
    private int bulletSpeed;

    @Override
    public void setBulletSpeed(int kmPerHr) {
        this.bulletSpeed = kmPerHr;
    }

    @Override
    public int getBulletSpeed() {
        return bulletSpeed;
    }

    @Override
    public void reset() {
        bulletSpeed = 0;
    }
}
