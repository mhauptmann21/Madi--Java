
public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public  Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    // Return radius
    public double getRadius() {
        return radius;
    }

    // Set a new radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Return area
    @Override 
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // Return diameter
    public double getDiameter() {
        return 2 * radius;
    }

    //Return perimeter
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // Return true if obejects radii are the same
    @Override
    public boolean equals(Object o) {
        return this.compareTo((Circle)o) == 0;
    }

    // Implement compareTo method
    @Override
    public int compareTo(Circle o) {
        if (this.radius > o.radius)
            return 1;
        else if (this.radius < o.radius)
            return -1;
        else
            return 0;
    }

    // Implement the toString method in GeometricObject
    @Override
    public String toString() {
        return super.toString() + "\nDate created: " + getDateCreated() + "\nRadius: " + radius;
    }

    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(5.0);
        Circle c3 = new Circle(7.0);
        
        System.out.println(c1.equals(c2)); // true
        System.out.println(c1.equals(c3)); // false
        System.out.println(c1.compareTo(c3)); // negative value
    }
}