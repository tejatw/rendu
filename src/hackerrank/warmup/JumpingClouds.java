package hackerrank.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//0 1 0 0 0 1 0

public class JumpingClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        int noOfJumps = 0;

        int currentCloud = 0;
        int jump = 1;

        while (jump < c.length) {

            if (c[jump] == 1) {

//                noOfJumps = noOfJumps + 1;
//                jump = jump + 1;
            }
            else if (c[jump] == 0){

                    if (jump < c.length - 1 && c[jump + 1] == 0 && (jump + 1 - currentCloud < 3)) {

                        jump = jump + 1;
                        noOfJumps = noOfJumps + 1;
                        currentCloud = jump;
                    }
                else{

                    currentCloud = jump;
                    noOfJumps = noOfJumps + 1;
                }
            }
            jump = jump + 1;
        }


        return noOfJumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = {0, 1, 0, 0, 0, 1, 0};

//        String[] cItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int cItem = Integer.parseInt(cItems[i]);
//            c[i] = cItem;
//        }

        int result = jumpingOnClouds(c);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

