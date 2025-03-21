class RegularPolygon {
  private int n = 3; // Number of sides, default is 3
  private double side = 1; // Length of each side, default is 1
  private double x = 0; // X-coordinate of center, default is 0
  private double y = 0; // Y-coordinate of center, default is 0

  // No-arg constructor
  public RegularPolygon() {
  }

  // Constructor with specified number of sides and length of side
  public RegularPolygon(int n, double side) {
      this.n = n;
      this.side = side;
  }

  // Constructor with specified number of sides, length of side, and center coordinates
  public RegularPolygon(int n, double side, double x, double y) {
      this.n = n;
      this.side = side;
      this.x = x;
      this.y = y;
  }

  // Accessor and mutator methods
  public int getN() {
      return n;
  }
  public void setN(int n) {
      this.n = n;
  }
  public double getSide() {
      return side;
  }
  public void setSide(double side) {
      this.side = side;
  }
  public double getX() {
      return x;
  }
  public void setX(double x) {
      this.x = x;
  }
  public double getY() {
      return y;
  }
  public void setY(double y) {
      this.y = y;
  }

  // Method to calculate the perimeter
  public double getPerimeter() {
      return n * side;
  }
  // Method to calculate the area
  public double getArea() {
      return (n * side * side) / (4 * Math.tan(Math.PI / n));
  }
}

// Test program
public class TestRegularPolygon {
  public static void main(String[] args) {
      RegularPolygon polygon1 = new RegularPolygon();
      RegularPolygon polygon2 = new RegularPolygon(6, 4);
      RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

      System.out.println("Polygon 1: Perimeter = " + polygon1.getPerimeter() + ", Area = " + polygon1.getArea());
      System.out.println("Polygon 2: Perimeter = " + polygon2.getPerimeter() + ", Area = " + polygon2.getArea());
      System.out.println("Polygon 3: Perimeter = " + polygon3.getPerimeter() + ", Area = " + polygon3.getArea());
  }
}
