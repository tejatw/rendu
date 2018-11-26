import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SortedSubsequence
{
    // A function to find a sorted subsequence of size 3
    static void find3Numbers(int arr[])
    {
        int n = arr.length;
        int max = n-1; //Index of maximum element from right side
        int min = 0; //Index of minimum element from left side
        int i;

        // Create an array that will store index of a smaller
        // element on left side. If there is no smaller element
        // on left side, then smaller[i] will be -1.
        int[] smaller = new int[n];
        smaller[0] = -1;  // first entry will always be -1
        for (i = 1; i < n; i++)
        {
            System.out.print(i + " ");
            System.out.print(min + " ");
            if (arr[i] <= arr[min])
            {
                min = i;
                smaller[i] = -1;
            }
            else
                smaller[i] = min;

            //System.out.print(min + " ");
            System.out.println(smaller[i]);
        }

        // Create another array that will store index of a
        // greater element on right side. If there is no greater
        // element on right side, then greater[i] will be -1.
        int[] greater = new int[n];
        greater[n-1] = -1;  // last entry will always be -1

        System.out.println();
        for (i = n-2; i >= 0; i--)
        {
            System.out.print(i + " ");
            System.out.print(max + " ");
            if (arr[i] >= arr[max])
            {
                max = i;
                greater[i] = -1;
            }
            else
                greater[i] = max;

            System.out.println(greater[i] + " ");
        }


//        System.out.println(greater.toString());

        // Now find a number which has both a greater number
        // on right side and smaller number on left side
        for (i = 0; i < n; i++)
        {
            if (smaller[i] != -1 && greater[i] != -1)
            {
                System.out.print(arr[smaller[i]]+" "+
                        arr[i]+" "+ arr[greater[i]]);
                return;
            }
        }



        // If we reach number, then there are no such 3 numbers
        System.out.println("No such triplet found");
        return;
    }

    public static void main (String[] args)
    {
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        find3Numbers(arr);
    }
}
