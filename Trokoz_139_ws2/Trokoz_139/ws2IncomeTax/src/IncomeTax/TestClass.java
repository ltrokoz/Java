/**********************************************
 Workshop # 2
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    13-02-2021
 **********************************************/

package IncomeTax;

import java.util.Scanner;

public class TestClass {

    public static int[][] intervals2001 = {
            { 27050, 65550, 136750, 297350 },
            { 45200, 109250, 166500, 297350 },
            { 22600, 54625, 83250, 148675 },
            { 36250, 93650, 151650, 297350 }
    };

    public static double[] taxRate2001 = { 0.15, 0.275, 0.305, 0.355, 0.391 };

    public static void mainMenu() {
        System.out.print("\nMAIN MENU :\n\n");
        System.out.print("1 - Compute personal income Tax\n");
        System.out.print("2 - Print the tax tables for taxable incomes (with range)\n");
        System.out.print("0 - Exit\n\n");
    }

    public static void filingStatus() {
        System.out.print("\nIncome Tax Calculator:\n");
        System.out.print("0 - single filer\n");
        System.out.print("1 - married jointly or qualifying widow(er)\n");
        System.out.print("2 - married separately\n");
        System.out.print("3 - head of the household\n");
    }

    public static void main(String[] args) {

        IncomeTax tax2001 = new IncomeTax(0, intervals2001, taxRate2001, Integer.MAX_VALUE);
        IncomeTax tax2009 = new IncomeTax();
        mainMenu();
        System.out.print("Selection option : ");
        Scanner input = new Scanner(System.in);
        int opt = input.nextInt();

        if (opt < 0 || opt > 2) {
            System.out.print("Wrong input.\n");
        }
        else if (opt == 0) System.out.print("\nExiting...\n");
        else {
            switch (opt) {
                case 1:
                    IncomeTax computeTax = new IncomeTax();
                    int status;
                    double taxIncome;
                    filingStatus();
                    System.out.print("\nEnter the filling status: ");
                    status = input.nextInt();
                    if (status < 0 || status > 3) {
                        System.out.print("Wrong input.\n"); break;
                    }
                    computeTax.setStatusInput(status);
                    System.out.print("Enter the Taxable Income: $");
                    taxIncome = input.nextDouble();
                    computeTax.setTaxableIncome(taxIncome);
                    computeTax = new IncomeTax(status, tax2009.getIntervals(), tax2009.getRates(), taxIncome);
                    System.out.println("Tax is: " + computeTax.getIncomeTax());
                    break;
                case 2:
                    int interval = 1000;
                    System.out.print("\nEnter the amount From: $");
                    double fromIncome = input.nextDouble();
                    System.out.print("Enter the amount To: $");
                    double toIncome = input.nextDouble();

                    int count = (int) ((toIncome - fromIncome) / 1000);
                    boolean err = false;
                    if (count <= 0) {
                        System.out.print("Cannot be calculated\n");
                        err = true;
                    } else if (fromIncome < 500 || toIncome < 500) {
                        System.out.print("Too small values\n");
                        err = true;
                    } else if (count > 30) {
                        System.out.print("Too large table\n");
                        err = true;
                    }
                    if (!err) {
                        System.out.printf("\n2001 tax tables for taxable income from $%.0f to $%.0f\n", fromIncome, toIncome);
                        print(tax2001, fromIncome, toIncome, interval);
                        System.out.printf("\n\n2009 tax tables for taxable income from $%.0f to $%.0f\n", fromIncome, toIncome);
                        print(tax2009, fromIncome, toIncome, interval);
                    }
                    break;
            }
        }
    }

    public static void print(IncomeTax incomeTax, double fromIncome, double toIncome, double interval) {

        System.out.print("--------------------------------------------------------------------------\n");
        System.out.print("Taxable     Single      Married Joint     Married        Head of\n");
        System.out.print("Income                  or Qualifying     Separate       a house\n");
        System.out.print("                        Widow(er)\n");
        System.out.print("--------------------------------------------------------------------------\n");

        for (double taxableIncome = fromIncome; taxableIncome <= toIncome; taxableIncome += interval) {
            incomeTax.setTaxableIncome(taxableIncome);
            System.out.printf("%-12.0f", taxableIncome);
            incomeTax.setStatusInput(incomeTax.SINGLE_FILER);
            System.out.printf("%-12.2f", incomeTax.getIncomeTax());
            incomeTax.setStatusInput(incomeTax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW);
            System.out.printf("%-18.2f", incomeTax.getIncomeTax());
            incomeTax.setStatusInput(incomeTax.MARRIED_SEPARATELY);
            System.out.printf("%-15.2f", incomeTax.getIncomeTax());
            incomeTax.setStatusInput(incomeTax.HEAD_OF_HOUSEHOLD);
            System.out.printf("%-12.2f\n", incomeTax.getIncomeTax());
        }
    }
}
