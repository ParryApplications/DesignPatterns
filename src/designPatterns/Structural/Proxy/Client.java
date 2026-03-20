package designPatterns.Structural.Proxy;

import java.awt.*;
import java.awt.geom.Point2D;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) throws NoSuchMethodException {
        Factory factory = new Factory();

        //Static Proxy Call
        Image image = factory.getImageByStaticProxy("passport.png");
        image.setLocation(new Point2D.Float(1.2f,2.4f));

        image.render();

        image.setLocation(new Point2D.Float(2.2f,3.4f));


        //Dynamic Proxy Call
        Image imageByDynamicProxy = factory.getImageByDynamicProxy("Aadhaar_Card.png");
        imageByDynamicProxy.setLocation(new Point2D.Float(9.8f,4.6f));

        imageByDynamicProxy.render();

        imageByDynamicProxy.setLocation(new Point2D.Float(6.8f,8.6f));
    }
}
