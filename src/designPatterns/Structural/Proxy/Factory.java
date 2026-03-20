package designPatterns.Structural.Proxy;

import java.lang.reflect.Proxy;

public class Factory {

    public Image getImageByStaticProxy(String fileName) {
        return new StaticProxy(fileName);
    }

    public Image getImageByDynamicProxy(String fileName) {
        return (Image) Proxy.newProxyInstance(Factory.class.getClassLoader(), new Class[]{Image.class}, new DynamicProxy(fileName));
    }
}
