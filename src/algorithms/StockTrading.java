package algorithms;

import java.util.Scanner;

public class StockTrading {

	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();

		while (count-- > 0) {

			int noOfDays = scan.nextInt();

			int[] stockValues = new int[noOfDays];

			for (int i =0; i< noOfDays; i++) {

				stockValues[i] = scan.nextInt();
			}

			int i = 0;
			for(; i < noOfDays-1; i++) {

				if(stockValues[i] < stockValues[i+1])
					break;
			}

			if (i == (noOfDays - 1)) {
				System.out.println("No Profit");
			}
			else {

				for (i=1; i<noOfDays; i++) {

					if (stockValues[i-1] < stockValues[i]) {
						System.out.print(i-1 + "-");
						try {
							while(stockValues[i-1] < stockValues[i] && i < noOfDays) {
								i++;
								continue;
							}
						}
						catch(Exception e) {
						}
						System.out.print(i-1 + " ");
					}
				}
			}
		}
	}
}

