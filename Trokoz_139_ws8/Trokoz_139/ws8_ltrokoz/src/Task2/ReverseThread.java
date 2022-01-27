/**********************************************
 Workshop # 8
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    05-04-2021
 **********************************************/

package Task2;

public class ReverseThread extends Thread {
    static int numOfThread = 50;  // set the number of threads

    public void run() {
        try {
            ReverseThread.numOfThread--;  // sort the threads in the reverse
            if (ReverseThread.numOfThread < 0) {
                return;
            }
            make();
            System.out.println("Hello from " + this.getName() + "!");  // output for each thread
        } catch (InterruptedException e) {
        }
    }

    public void make() throws InterruptedException {
        ReverseThread t = new ReverseThread();
        t.start();
        t.join();
    }

    public static void main(String[] args) {
        ReverseThread thread = new ReverseThread();
        thread.start();
    }
}