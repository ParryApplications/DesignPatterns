package designPatterns.Creational.Singleton;

//Eagerly Init
//Thread safe
//Singleton
public class SingletonWithEagerInit {
    private SingletonWithEagerInit() {
    }//It'll not allowed you to instantiate the class as well as take care of the inheritance

    private static final SingletonWithEagerInit INSTANCE = new SingletonWithEagerInit();

    public static SingletonWithEagerInit getInstance() {
        return INSTANCE;
    }

}
