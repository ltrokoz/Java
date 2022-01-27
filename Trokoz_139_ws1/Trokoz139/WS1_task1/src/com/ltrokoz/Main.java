/**********************************************
 Workshop # 1
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    29-01-2021
 **********************************************/

package com.ltrokoz;

import java.util.Scanner;  // Import the Scanner class

public class Main {
    static int row ;
    static int column;

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter the number of rows and columns in the array: ");

        row = myObj.nextInt();
        column = myObj.nextInt();

        float[][] biArray = new float[row][column];
        int[] location = new int[2];
        float maxValue = biArray[0][0];

        System.out.println("\nEnter the array:");

        for (int i = 0; i < biArray.length; i++){
            for (int j = 0; j < biArray[i].length; j++) {
                biArray[i][j] = myObj.nextFloat();

                if (biArray[i][j] > maxValue) {
                    maxValue = biArray[i][j];
                    location[0] = i;
                    location[1] = j;
                }
            }
        }

// Display results
        if (maxValue % 1 == 0 ) {
            System.out.println("The location of the largest element is " +
                    (int)maxValue + " at (" + location[0] + ", " + location[1] + ")");
        } else  {
            System.out.println("The location of the largest element is " +
                    maxValue + " at (" + location[0] + ", " + location[1] + ")");
        }
    }
}
