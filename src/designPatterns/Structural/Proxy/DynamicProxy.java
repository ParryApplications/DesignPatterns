package designPatterns.Structural.Proxy;

import java.awt.geom.Point2D;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private PngImage pngImage;
    private Point2D location;
    private String fileName;

    public DynamicProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(proxy instanceof Image) {
            Method setLocation = Image.class.getMethod("setLocation", Point2D.class);
            Method getLocation = Image.class.getMethod("getLocation");
            Method render = Image.class.getMethod("render");

            if (method.equals(setLocation)) {
                if (pngImage == null) {
                    this.location = (Point2D) args[0];
                } else {
                    pngImage.setLocation((Point2D) args[0]);
                }
            } else if (method.equals(getLocation)) {
                if (pngImage != null) return pngImage.getLocation();
                return location;
            } else if (method.equals(render)) {
                if (pngImage == null) {
                    pngImage = new PngImage(fileName);
                    if (location != null) pngImage.setLocation(location);
                }
                pngImage.render();
            } else {
                return method.invoke(pngImage, args);
            }
        }
        return null;
    }
}
