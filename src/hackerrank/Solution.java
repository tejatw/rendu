package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int maxValue = 0;
        boolean setMaxValue = false;
        for (int i =0; i <= arr.length - 3; i++){
            for (int j = 0; j <= arr[0].length - 3; j++){
                int tempValue = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                System.out.println(tempValue);
                if (setMaxValue == false){
                    maxValue = tempValue;
                    setMaxValue = true;
                }
                else if (tempValue > maxValue){
                    maxValue = tempValue;
                }
            }
        }

        return maxValue;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[5][6];

        for (int i = 0; i < 5; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(arr.length);
        System.out.println(arr[0].length);

        System.out.println("max sum is " + result);


//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
