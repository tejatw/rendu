package hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {


        char[] inputString = s.toCharArray();

        int itr = 0;

        int singleCount = 0;

        long totalCount = 0;

        if (inputString.length == 1 && inputString[0] == 'a') {
            return n;
        }


        while (itr < inputString.length){

            if (inputString[itr] == 'a') {

                singleCount++;
            }

            itr = itr + 1;

        }

        totalCount = (n /inputString.length) * singleCount;

        itr = 0;


        while (itr < n%inputString.length){

            if (inputString[itr] == 'a') {

                totalCount++;
            }

            itr = itr + 1;

        }

        return totalCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "aaabc";

//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, 10);


        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

//        scanner.close();
    }
}