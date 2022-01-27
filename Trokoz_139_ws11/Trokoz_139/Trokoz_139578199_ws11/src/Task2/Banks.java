/**********************************************
 Workshop # 11
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    20-04-2021
 **********************************************/

package Task2;

import java.util.Scanner;

public class Banks {
    static int bankID = 0;
    static int amountLoaned = 1;
    static double[][][] banksList;

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        // Prompt user input number of banks
        System.out.print("\nNumber of banks: ");
        int numberOfBanks = input.nextInt();
        // Prompt user input assets limit
        System.out.print("Minimum asset limit: ");
        int minimumLimit = input.nextInt();
        String string = "";
        banksList = new double[numberOfBanks][][];

        for (int i = 0; i < banksList.length; i++) {
            System.out.println("\nFor Bank # " + i);
            // Prompt user input bank`s balance
            System.out.print("\tBalance: ");
            double balance = input.nextDouble();
            // Prompt user input number of banks loaned
            System.out.print("\tNumber of banks Loaned: ");
            int numBanks = input.nextInt();

            banksList[i] = new double[++numBanks][2];
            banksList[i][0][0] = balance;

            for (int bankBorr = 1; bankBorr < banksList[i].length; bankBorr++) {
                // Prompt user to input borrower bank ID
                System.out.print("\t\tBank ID who gets the loan: ");
                banksList[i][bankBorr][bankID] = input.nextDouble();
                // Prompt user to input the amount loaned
                System.out.print("\t\tLoaned Amount: ");
                banksList[i][bankBorr][amountLoaned] = input.nextDouble();
            }
        }

        boolean[] unsafe = checking (banksList, minimumLimit);

        // Notify bankrupted banks
        System.out.println();
        for (int i = 0; i < unsafe.length; i++) {
            if (unsafe[i]) string += " Bank " + i;
        }
        System.out.print("Unsafe banks are" + string + "\n");

    }
    // Check unsafe bank
    public static boolean[] checking (double[][][] list, int limit) {
        boolean[] unsafeBank = new boolean[list.length];
        double total;
        boolean isSafe = false;
        while (!isSafe) {
            isSafe = true;
            for (int banks = 0; banks < list.length; banks++) {
                total = list[banks][0][0];
                for (int bankB = 1; bankB < list[banks].length; bankB++) {
                    int ind = (int) list[banks][bankB][bankID];
                    if (!unsafeBank[ind]) total += list[banks][bankB][amountLoaned];
                }
                if (total < limit && !unsafeBank[banks]) {
                    unsafeBank[banks] = true;
                    isSafe = false;
                }
            }
        }
        return unsafeBank;
    }
}