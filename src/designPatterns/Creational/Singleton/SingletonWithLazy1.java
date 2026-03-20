package designPatterns.Creational.Singleton;

import designPatterns.Creational.Factory.AbstractFactory.Instance;

//Lazy Init
//Thread safe with Synchronized
//Singleton
public class SingletonWithLazy1 {

    private SingletonWithLazy1() {
    }

    private volatile static SingletonWithLazy1 INSTANCE;//Not yet initialized

    public static SingletonWithLazy1 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonWithLazy1.class) {
                if (INSTANCE == null)
                    INSTANCE = new SingletonWithLazy1();
            }
        }

        return INSTANCE;
    }
}
