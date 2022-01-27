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

package Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Hangman {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BufferedReader bread;
        BufferedWriter bwrite;
        Vector<String> tries = new Vector<>();
        Random rnd = new Random();
        int misses = 0;
        char yn;

        System.out.println("\nGame starts\n");

        do {
            String YNinput = "";
            /** Hardcode file with words */
            String file = "Hangman.txt";
            bread = new BufferedReader(new FileReader(file));
            Vector<String> words = new Vector<>();
            String line;

            while ((line = bread.readLine()) != null) {
                words.add(line);
            }
            bread.close();
            String answer = words.get(rnd.nextInt(words.size()));
            String hiddenAns = new String();

            for (int i = 0; i < answer.length(); i++) {
                hiddenAns += '*';
            }

            while (hiddenAns.indexOf("*") != -1) {
                System.out.printf("(Guess) Enter a letter in word %s > ", hiddenAns);
                String guess = sc.next();

                for (int i = 0; i < answer.length(); i++) {
                    if (hiddenAns.charAt(i) == guess.charAt(0)) {
                        System.out.println("        " + guess + " is already in the word" );
                    }
                }
                tries.add(guess);
                if (answer.indexOf(guess) != -1) {
                    String copy = hiddenAns;
                    hiddenAns = "";
                    for (int i = 0; i < answer.length(); i++) {
                        if (answer.charAt(i) == guess.charAt(0)) {
                            hiddenAns += answer.charAt(i);
                        } else {
                            hiddenAns += copy.charAt(i);
                        }
                    }
                } else {
                    System.out.println("        " + guess + " is not in the word");
                    misses++;
                }
            }
            System.out.printf("The word is %s. You missed %s %s\n", answer, misses, (misses == 1 ? "time" : "times"));
            System.out.print("Enter a new word to be added in the memory> ");
            String word = "";
            word += sc.nextLine();
            word += sc.nextLine();
            bwrite = new BufferedWriter(new FileWriter(file, true));
            bwrite.write(word + "\n");
            bwrite.close();

            do {
                System.out.print("Do you want to guess another word? Enter y or n> ");
                YNinput = sc.next();
                yn = YNinput.charAt(0);
            }
            /** Check user`s input */
            while((yn != 'Y' && yn != 'y' && yn != 'N' && yn != 'n') || YNinput.length() > 1);
        }
        while(yn == 'Y' || yn == 'y');
        sc.close();
        System.out.println("\nGood buy.");
    }
}