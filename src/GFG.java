
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner  s= new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
		    int m = s.nextInt();
		    int n=s.nextInt();
		    
		    int[] arr = new int[10];
		    prirange(m,n,arr);
		   
		}
	}
	
	static void prirange(int m,int n,int[] arr)
	{
	    boolean k = false;
	    
	  boolean prime[] = new boolean[n+1];

    for (int p=2; p*p<=n; p++)
    {
        // If prime[p] is not changed, then it is a prime
        if (prime[p] == false)
        {
            // Update all multiples of p
            for (int i=p*2; i<=n; i += p)
                prime[i] = true;
        }
    }
	    
	    for(int i=m;i<=n;i++)
	    {
	     if(prime[i]==false)
	     {
	         k=true;
	         String str= Integer.toString(i);
	         for(int j=0;j<str.length();j++)
	         {
	             int b = str.charAt(j)-'0';
	             arr[b]=arr[b]+1;
	         }
	     }
	}
int max=Integer.MIN_VALUE;
	int ans=-1;
	  for(int i=0;i<arr.length;i++)
	    {
	       if(arr[i]>=max)
	       {
	    	   ans=i;
	       max=arr[i];
	       }
	    }
	if(k==false)
	System.out.println("-1");
	else
	System.out.println(ans);
}

}