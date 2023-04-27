// ****************************************************************************
//   Areas.java
// 
//   Reads shape data from a text file and writes data to corresponding text files.
// ****************************************************************************
import java.util.*;
import java.io.*;

public class Areas
{
    // --------------------------------------------------------------------
    //   Reads shape data from a text file, computes the area, 
    //   then writes data to another file based on the shape type
    // -------------------------------------------------------------------- 
    public static void main (String[] args)
    {

	String shapeType;		// type of shape
	double area;         	// area of the shape
	double radius;    		// circle dimension
	double side;            // square dimension
	double length, width;	// rectangle dimensions
	double base, height;	// triangle dimensions

	String name, inputName = "shapes.txt";
	String circleName = "circles.txt";
	String squareName = "squares.txt";
	String rectangleName = "rectangles.txt";
	String triangleName = "triangles.txt";
	Shape shapeObj = null;
	
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter filename: ");
	inputName = scan.next();
	
	
	
	PrintWriter squares=null;
	PrintWriter circles=null;
	PrintWriter rectangles=null;
	PrintWriter triangles=null;
	Scanner input=null;
	try  {
		// Set up Scanner to input file
		    File file = new File(inputName);
			input = new Scanner (file);
			 
			
		// Set up the output file streams
			squares = new PrintWriter(squareName);
			circles = new PrintWriter(circleName);
			rectangles = new PrintWriter(rectangleName);
			triangles = new PrintWriter(triangleName);
	
        
		// Print a header to each of the output files
		squares.println ();
		squares.println ("Square");
		squares.println ();
		squares.println ("Area" + "\t" + "Side Length");
		squares.println ();

		circles.println ();
		circles.println ("Circle");
		circles.println ();
		circles.println ("Area" + "\t" + "Radius");
		circles.println ();
		
		rectangles.println ();
		rectangles.println ("Rectangle");
		rectangles.println ();
		rectangles.println ("Area" + "\t" + "Length" + "\t" + "Width");
		rectangles.println ();
		
		triangles.println ();
		triangles.println ("Triangle");
		triangles.println ();
		triangles.println ("Area" + "\t" + "Base" + "\t" + "Height");
		triangles.println ();
		
		// Process the input file, one token at a time
		while (input.hasNext())
		    {
			// Get the shape name and dimension(s)
			shapeType = input.next();
			// Instantiate the correct object for shapeObj
			
			// Calculate the corresponding area using the correct area() method
			
			// Write the shape dimension(s) and area in the correct file
			if (shapeType.equalsIgnoreCase("Circle")) {
				radius = input.nextDouble();
				if (radius<0) {
					throw new NegativeNumberException();
				}
				shapeObj = new Circle(shapeType, radius);
				circles.println(shapeObj.area() + "\t" + radius);
			}
			else if (shapeType.equalsIgnoreCase("Square")) {
				side = input.nextDouble();
				if (side<0) {
					throw new NegativeNumberException();
				}
				shapeObj = new Square(shapeType, side);
				squares.println(shapeObj.area() + "\t" + side);
			}
			else if(shapeType.equalsIgnoreCase("Rectangle")) {
				length = input.nextDouble();
				width = input.nextDouble();
				
				if (length <0 || width < 0) {
					throw new NegativeNumberException();
				}
				
				shapeObj = new Rectangle(shapeType, length, width);
				rectangles.println(shapeObj.area() + "\t" + length + "\t" + width);
			}
			else if (shapeType.equalsIgnoreCase("Triangle")) {
				base = input.nextDouble();
				height = input.nextDouble();
				
				if (base<0 || height < 0) {
					throw new NegativeNumberException();
				}
				
				shapeObj = new Triangle(shapeType, base, height);
				triangles.println(shapeObj.area() + "\t" + base + "\t" + height);
			}
		    }
	    }
		
		//Add a catch for each of the specified exceptions, and in each case 
	catch(FileNotFoundException ex) {
    	System.out.println(ex.getMessage());	
    }
	catch (NegativeNumberException ex) {
		System.out.println(ex.getMessage());
	}
	catch (InputMismatchException ex) {
		System.out.println(ex.getMessage());
	}
		//give as specific a message as you can
	finally {
		input.close();
		squares.close();
		circles.close();
		triangles.close();
		rectangles.close();
	}
	
	
    }
}
