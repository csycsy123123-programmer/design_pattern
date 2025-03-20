package design_pattern.factory;

public class Rectangle implements Shape {
    public Rectangle() {

    }

    @Override
    public void draw() {
        System.out.println("i am rectangle");
    }
}
