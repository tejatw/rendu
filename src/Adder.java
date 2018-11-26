import java.util.Scanner;

public class Adder {
    public static void main (String[] args) {
        Scanner s  = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++){
            int n = s.nextInt();
            int a[] = new int[n];
            for(int j=0;j<n-1;j++){
                a[j] = s.nextInt();
            }
            int sum = n*(n+1)/2;
            System.out.println(sum);
            for(int j=0;j<n-1;j++){
                sum = sum-a[j];
            }
            System.out.println(sum);
        }
    }
}