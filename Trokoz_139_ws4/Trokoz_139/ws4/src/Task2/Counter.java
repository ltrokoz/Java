/**********************************************
 Workshop # 4
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    27-02-2021
 **********************************************/

package Task2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Counter {
    public static void main(String[] args) throws Exception {

        //** Upper and lowercase letter */
        char[] letters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".toCharArray();
        int[] count = new int[letters.length];

        System.out.print("Enter a filename: ");
        Scanner scan = new Scanner(System.in);
        String file = scan.nextLine();
        BufferedReader buffread = new BufferedReader(new FileReader(file));

        int charInt;
        while ((charInt = buffread.read()) != -1) {
            for (int i = 0; i < letters.length; i++) {
                char currentChar = (char) charInt;
                if (currentChar == letters[i]) {
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < letters.length; i++) {
            System.out.printf("Number of %c's: %d\n", letters[i], count[i]);
        }
        buffread.close();
        scan.close();
    }
}
