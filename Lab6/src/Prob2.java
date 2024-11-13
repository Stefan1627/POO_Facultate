import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

abstract class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        this("red", true);
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}

class Circle extends Shape {
    private double radius;
    public Circle() {
        this(0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: " + radius + ", " + getColor() + ", " + isFilled();
    }
}

class Rectangle extends Shape {
    private  double width;
    private double length;

    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * width + 2 * length;
    }

    @Override
    public String toString() {
        return "rectangle: " + width + ", " + length + ", "
                + getColor() + ", " + isFilled();
    }
}

class Square extends Rectangle {
    public Square() {
        super(0, 0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public void setWidth(double width) {
        super.setWidth(width);
    }

    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Square: " + getSide() + ", " + getWidth() + ", " + getLength();
    }
}

public class Prob2 {
    public static void main(String[] args) {
        Rectangle ret = new Rectangle();
        if (ret instanceof Shape)
            System.out.println("Da");

        if (ret instanceof Square)
            System.out.println("Da1");

        Square square = new Square();
        if (square instanceof Shape)
            System.out.println("Da2");
        if (square instanceof Rectangle)
            System.out.println("Da3");
        /*if (square instanceof Circle) {
            System.out.println("Da4");
        }
        else {
            System.out.println("Da5");
        }*/
    }
}
