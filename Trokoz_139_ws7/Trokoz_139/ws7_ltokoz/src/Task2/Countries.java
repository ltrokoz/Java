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

package Task2;

import java.util.HashMap;
import java.util.Scanner;

public class Countries {

   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, String> map = new HashMap<String, String>();

        // 25 countries and their capitals are stored in a map
        map.put("Ukraine", "Kyiv");
        map.put("Canada", "Ottawa");
        map.put("Mexico", "Mexico City");
        map.put("Brazil", "Brasilia");
        map.put("Jamaica", "Kingston");
        map.put("Maldives", "Male");
        map.put("USA", "Washington D.C.");
        map.put("Australia", "Canberra");
        map.put("Egypt", "Cairo");
        map.put("Kenya", "Nairobi");
        map.put("China", "Beijing");
        map.put("India", "New Delhi");
        map.put("Japan", "Tokyo");
        map.put("Italy", "Rome");
        map.put("Poland", "Warsaw");
        map.put("France", "Paris");
        map.put("Spain", "Madrid");
        map.put("Pakistan", "Islamabad");
        map.put("Venezuela", "Caracas");
        map.put("Sweden", "Stockholm");
        map.put("Bolivia", "Sucre");
        map.put("Denmark", "Copenhagen");
        map.put("Andorra", "Andorra la Vella");
        map.put("Austria", "Vienna");
        map.put("Barbados", "Bridgetown");

        // Prompt the user to enter a country
        System.out.print("\nPlease, enter a country to find its capital: ");
        String country = sc.next();

        // Display the capital for that country
        if (map.get(country) != null) {
            System.out.printf("The capital of %s is %s\n", country, map.get(country));
        } else {
            System.out.println("Sorry, for this country a capital cannot be found.");
        }

       sc.close();
    }
}
