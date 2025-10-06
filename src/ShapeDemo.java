// Abstract class Shape
abstract class Shape {


    abstract double area();
    abstract double perimeter();

    // Concrete (non-abstract) method
    void display() {
        System.out.println("This is a shape.");
    }
}


class Circle extends Shape {

    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing abstract methods
    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class extending Shape
class Rectangle extends Shape {

    private double length, width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing abstract methods
    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

// Main class to test
public class ShapeDemo {
    public static void main(String[] args) {

        // Create objects of Circle and Rectangle
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        // Display results
        System.out.println("=== Circle ===");
        System.out.println("Area: " + circle.area());
        System.out.println("Perimeter: " + circle.perimeter());

        System.out.println("\n=== Rectangle ===");
        System.out.println("Area: " + rectangle.area());
        System.out.println("Perimeter: " + rectangle.perimeter());
    }
}


