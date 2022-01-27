/**********************************************
 Workshop # 7
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    27-03-2021
 **********************************************/

package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BabyNames {

    public static ArrayList<String> lines = new ArrayList<>();
    public static ArrayList<String> boyNames = new ArrayList<>();
    public static ArrayList<String> girlNames = new ArrayList<>();
    public static ArrayList<String> matches = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter one of the filenames
        System.out.print("\nPlease enter a file name: ");
        String filename = sc.next();

        try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception err) {
            err.printStackTrace();
        }

        for (String line : lines) {
            String[] arr = line.split("\t");
            for (String item : arr) {
                item.trim();
            }

            boyNames.add(arr[1]);

            // Remove trailing whitespace
            girlNames.add(arr[3].substring(0, arr[3].length() - 1));
        }

        // Find common names in two lists
        for (String boy : boyNames) {
            for (String girl : girlNames) {
                if (boy.equals(girl)) matches.add(boy);
            }
        }

        System.out.printf("\n%d names used for both genders\n", matches.size());
        System.out.println("They are ");
        for (String name : matches) {
            System.out.printf("%s\t", name);
        }
        System.out.println("");

        // Sort all names for boys and girls in their lists
        Collections.sort(boyNames);
        Collections.sort(girlNames);

        // Remove the duplicates
        for (String name : matches) {
            boyNames.remove(name);
            girlNames.remove(name);
        }

        // Display the sorted names individually
        System.out.println("\n\nThe boy and girl lists sorted without duplicates");
        System.out.println("\nThe boys` names: ");
        System.out.println(boyNames);
        System.out.println("\nThe girls` names: ");
        System.out.println(girlNames);

        sc.close();
    }
}
