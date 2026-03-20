package designPatterns.Creational.Singleton;

//Best Approach
//Lazy Init
//Thread-safe //JVM guarantee that inner class only initialized once even concurrently threads invoking
//Singleton
public class SingletonWithLazy2 {
    private SingletonWithLazy2() {
    }

    private static class InnerClass {
        private static final SingletonWithLazy2 INSTANCE = new SingletonWithLazy2();
    }

    public static SingletonWithLazy2 getInstance() {
        return InnerClass.INSTANCE;
    }
}
