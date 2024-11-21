
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

abstract class Shape {
    protected String color;
    protected boolean filled;

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

class Rectangle extends Shape {
    protected double width;
    protected double lenght;

    public Rectangle() {
        super();
        width = 0.0;
        lenght = 0.0;
    }

    @Override
    public double getArea() {
        return width * lenght;
    }

    @Override
    public double getPerimeter() {
        return 2 * width + 2 * lenght;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", lenght=" + lenght +
                '}';
    }

    public Rectangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    public Rectangle(double width, double lenght, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
}

class Circle extends Shape {
    protected double radius;

    public Circle() {
        super();
        radius = 0.0;
    }

    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * 3.14;
    }

    @Override
    public String toString() {
        return "Circle";
    }

    public Circle(double radius) {
        super();
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
        setLenght(side);
        setWidth(side);
    }

    @Override
    public String toString() {
        return "Square";
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
    }

    @Override
    public void setLenght(double side) {
        super.setLenght(side);
    }

    public double getLength() {
        return super.getLenght();
    }
}

public class Prob2 {
    public static void main(String[] args) {
        Shape c1 = new Circle();
        Square sq = (Square) c1;
        
//Conversie 2
        Rectangle r = new Rectangle(5.0, 5.0);
        sq = (Square) r;
//Conversie 3
        sq = new Square(7.0);
        r = sq;
    }
}