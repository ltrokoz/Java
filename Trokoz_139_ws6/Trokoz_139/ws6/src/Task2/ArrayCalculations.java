/**********************************************
 Workshop # 6
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    20-03-2021
 **********************************************/

package Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ArrayCalculations {

    public static void main(String[] args) {

        System.out.println("\nPlease enter the numbers (when finish just enter 0)");

        Vector<Double> values = new Vector<>();
        double entered = 1;

        while (entered != 0) {
            System.out.print("Number to add: ");
            entered = readDouble();
            if (entered != 0) {
                values.add(entered);
            }
        }

        double[] arr = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            arr[i] = values.get(i);
        }

        System.out.println();
        System.out.println("The array of your numbers: " + values);
        System.out.println("\nArray processing");
        System.out.println("maximum value: " + max.apply(arr));
        System.out.println("minimum value: " + min.apply(arr));
        System.out.println("sum of the values: " + sum.apply(arr));
        System.out.println("average of the values: " + avg.apply(arr));
        System.out.print("\nPlease enter the value from your array for counting it: ");
        double searchValue = readDouble();
        ArrayProcessor findFunction = counter(searchValue);
        System.out.println(searchValue + " was entered " + findFunction.apply(arr) + " times.\n");
        System.out.println("Thank you. Goodbuy.");
    }

    // Find min value in the array
    public static final ArrayProcessor min = (arr) -> {
        Arrays.sort(arr);
        return arr[0];
    };
    // Find max value in the array
    public static final ArrayProcessor max = (arr) -> {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    };
    // Find sum of the array values
    public static final ArrayProcessor sum = (arr) -> {
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        return sum;
    };
    // Find average in the array
    public static final ArrayProcessor avg = (arr) -> {
        return (sum.apply(arr) / arr.length);
    };
    // Count number of entering value
    public static ArrayProcessor counter(double value) {
        ArrayProcessor cnt = (arr) -> {
            int count = 0;
            for (double num : arr) {
                if (num == value) {
                    count++;
                }
            }
            return count;
        };
        return cnt;
    }

    private static double readDouble() {
        Scanner sc = new Scanner(System.in);
        double entered = 1;
        boolean corr = false;
        while (!corr) {
            try {
                entered = sc.nextDouble();
                corr = true;
            } catch (Exception ignored) {
                sc.next();
                System.out.print("Try again: ");
                corr = false;
            }
        }
        return entered;
    }
}