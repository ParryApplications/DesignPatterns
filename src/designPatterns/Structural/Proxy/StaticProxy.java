package designPatterns.Structural.Proxy;

import java.awt.geom.Point2D;

public class StaticProxy implements Image {

    private String fileName;
    private Point2D location;
    private PngImage pngImage;

    public StaticProxy(String fileName) {
        this.fileName = fileName;
        //Not doing any loading eagerly until render pr display called
    }

    @Override
    public void setLocation(Point2D point2D) {
        if (pngImage != null)
            pngImage.setLocation(location);

        this.location = point2D;
    }

    @Override
    public Point2D getLocation() {
        if (pngImage != null) return pngImage.getLocation();
        return location;
    }

    @Override
    public void render() {
        if (pngImage == null) {
            pngImage = new PngImage(fileName);
            if (location != null) pngImage.setLocation(location);
        }
        pngImage.render();
    }
}
