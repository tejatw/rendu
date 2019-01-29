package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class MinimumBribe {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int noOfBribes = 0;
        for (int position = 0; position < q.length; position++){
            if(q[position] != (position + 1)){
                if(q[position] - (position + 1) > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                else{
                    noOfBribes += Math.abs(q[position] - (position + 1));
                }
            }
            else if (q[position] - (position +1) > 2){
                //System.out.println("2 - " + q[position]);
                System.out.println("Too chaotic");
                return;
            }
            else{
                //System.out.println("3 - " + q[position]);
                //System.out.println("4 - " + noOfBribes);
                noOfBribes += q[position] - (position + 1);
                //System.out.println("5 - " + noOfBribes);
            }
        }
        System.out.println(noOfBribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
