/************************************
* GeometricObject                   *
*-----------------------------------*
* -color: String                    *
* -filled: boolean                  *
* -dateCreated: java.util.Date      *
*-----------------------------------*
* +GeometricObject()                *
* +GeometricObject(color: String,   *
*	filled: boolean)                 *
* +getColor(): String               *
* +setColor(color: Stirng): void    *
* +isFilled(): boolean              *
* +setFilled(filled: boolean): void *
* +getDateCreated(): java.util.Date *
* +toString(): String               *
************************************/
import java.util.Scanner;

public abstract class GeometricObject {
  private String color = "white";
  private boolean filled;

  /**Default construct*/
  protected GeometricObject() {
  }

  /**Construct a geometric object*/
  protected GeometricObject(String color, boolean filled) {
    this.color = color;
    this.filled = filled;
  }

  /**Getter method for color*/
  public String getColor() {
    return color;
  }

  /**Setter method for color*/
  public void setColor(String color) {
    this.color = color;
  }

  /**Getter method for filled. Since filled is boolean,
     so, the get method name is isFilled*/
  public boolean isFilled() {
    return filled;
  }

  /**Setter method for filled*/
  public void setFilled(boolean filled) {
    this.filled = filled;
  }

  /**Abstract method findArea*/
  public abstract double getArea();

  /**Abstract method getPerimeter*/
  public abstract double getPerimeter();
}

/*********************************************************
*                       Triangle                         *
*--------------------------------------------------------*
* -side1: double                                         *
* -side2: double                                         *
* -side3: double                                         *
*--------------------------------------------------------*
* +Triangle()                                            *
* +Triangle(side1: double, side2: double, side3: double) *
* +getSide1(): double                                    *
* +getSide2(): double                                    *
* +getSide3(): double                                    *
* +getArea(): double                                     *
* +getPerimeter(): double                                *
* +toString(): String                                    *
*********************************************************/

class Triangle extends GeometricObject{
  // intializing data fields
  private double side1 = 1.0;
  private double side2 = 1.0;
  private double side3 = 1.0;

  // no-arg constructor that creates a default triangle
  public Triangle() {
  }

  // constructor that creates a triangle with specified sides
  public Triangle (double side1, double side2, double side3){
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  // the accessor methods for the three data fields
  public double getSide1(){
    return side1;
  }

  public double getSdie2(){
    return side2;
  }

  public double getSide3(){
    return side3;
  }

  //method that returns the area of the triangle
  public double getArea(){
    double s = (side1 + side2 + side3)/2;
    double area = Math.sqrt(s*(s - side1) * (s - side2) * (s - side3));
    return area;
  }

  // method that returns the perimeter of the triangle
  public double getPerimeter(){
    double perimeter = side1 + side2 + side3;
    return perimeter;
  }

  // method that returns a string decription for the triangle
  public String toString(){
    return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
  }
}
public class Exercise_11_01 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
      
    // Prompt the user to enter three sides of the triangle
		System.out.print("Enter three sides of the triangle: ");
		double side1 = input.nextDouble();		
		double side2 = input.nextDouble();		
		double side3 = input.nextDouble();

		// Prompt the user to enter a color
		System.out.print("Enter a color: ");
		String color = input.next();

		// Prompt the user to enter whether the triangle is filled
		System.out.print("Is the triangle filled (true / false)? ");
		boolean filled = input.nextBoolean();

		// Create triangle object with user input
		Triangle triangle = new Triangle(side1, side2, side3);
		triangle.setColor(color);
		triangle.setFilled(filled);

		System.out.println(triangle.toString());
		System.out.println("Area: " + triangle.getArea());
		System.out.println("Perimeter: " + triangle.getPerimeter());
		System.out.println("Color: " + triangle.getColor());
		System.out.println("Triangle is" + (triangle.isFilled() ? "" : " not") 	+ " filled");
  }
}