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

package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Arrays;

public class MatrixAddition implements Runnable {
    private final double[][] a;
    private final double[][] b;

    MatrixAddition(double[][] a, double[][] b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) { c[i][j] = a[i][j] + b[i][j]; }
        }
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        long start, end;

        double[][] a = new double[2000][2000];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) { a[i][j] = Math.random(); }
        }

        double[][] b = new double[2000][2000];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) { b[i][j] = Math.random(); }
        }

        // parallel addition
        System.out.println("\nParallel Test starts:");
        ExecutorService executorService = Executors.newCachedThreadPool();
        start = System.currentTimeMillis();  // test begins
        executorService.execute(new MatrixAddition(Arrays.copyOfRange(a, 0, 500), Arrays.copyOfRange(b, 0, 500)));
        executorService.execute(new MatrixAddition(Arrays.copyOfRange(a, 501, 1000), Arrays.copyOfRange(b, 501, 1000)));
        executorService.execute(new MatrixAddition(Arrays.copyOfRange(a, 1001, 1500), Arrays.copyOfRange(b, 1001, 1500)));
        executorService.execute(new MatrixAddition(Arrays.copyOfRange(a, 1501, 2000), Arrays.copyOfRange(b, 1501, 2000)));
        executorService.shutdown();
        end = System.currentTimeMillis();  // test ends
        // calculation the time of Parallel Test
        System.out.printf("Parallel matrix addition used %d milliseconds\n", (end - start));

        // normal sequential addition
        System.out.println("\nSequential Test starts:");
        Thread sequentialThread = new Thread(new MatrixAddition(a, b));
        start = System.currentTimeMillis();   // test begins
        sequentialThread.start();
        sequentialThread.join();
        end = System.currentTimeMillis();  // test ends
        // calculation the time of Sequential Test
        System.out.printf("Sequential matrix addition used %d milliseconds\n", (end - start));
    }
}