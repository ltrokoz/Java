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

package Task2;

import java.util.Scanner;

public class TestClass2 {
    public static void main(String[] args) {
        System.out.println("\nTriangle\n");
        try {
            Triangle2 t1 = new Triangle2(2, 2, 2);
            System.out.println("Perimeter = " + t1.getPerimeter());
            System.out.println("Area = " + t1.getArea());
            Triangle2 t2 = new Triangle2(0, 2, 2);
            System.out.println("Perimeter = " + t2.getPerimeter());
            System.out.println("Area = " + t2.getArea());
        }
        catch (Triangle2.TriangleException except) {
            System.out.println("\nIllegal triangle\n");
            System.out.println("Side1: " + except.getS1());
            System.out.println("Side2: " + except.getS2());
            System.out.println("Side3: " + except.getS3());
            except.printStackTrace();
        }
    }
}
