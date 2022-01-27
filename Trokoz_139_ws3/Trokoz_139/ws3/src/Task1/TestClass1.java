/**********************************************
 Workshop # 3
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    21-02-2021
 **********************************************/

package Task1;

import java.util.Scanner;

public class TestClass1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter three sides of a triangle: ");
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = input.nextDouble();
        }

        /** Check user`s input. Sides should be more then zero */
        if (sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0) {
            System.out.print("Wrong input.\n");
        }
        else {
            System.out.print("Enter a triangle color: ");
            String color = input.next();
            System.out.print("Is the triangle filled? true/false: ");
            String isFilledString = input.next();
            boolean isFilled = (isFilledString.equals("true"));
            Triangle t1 = new Triangle(sides[0], sides[1], sides[2]);
            t1.setColor(color);
            t1.setFilled(isFilled);
            System.out.println("\nTriangle:");
            System.out.println("Area = " + t1.getArea());
            System.out.println("Perimeter = " + t1.getPerimeter());
            System.out.println("Color = " + t1.getColor());
            System.out.println("Is filled? " + t1.isFilled());
        }
    }
}
