package designPatterns.Structural.Proxy;

import java.awt.geom.Point2D;

//Real Object
public class PngImage implements Image {

    private Point2D location;
    private String imageName;

    public PngImage(String imageName) {
        this.imageName = imageName;
        //Heavy Loading
    }

    @Override
    public void setLocation(Point2D point2D) {
        System.out.println("Setting Location by PngImage");
        this.location = point2D;
    }

    @Override
    public Point2D getLocation() {
        System.out.println("Getting Location by PngImage");
        return location;
    }

    @Override
    public void render() {
        System.out.println("Png " + imageName + " Rendered!");
    }
}
