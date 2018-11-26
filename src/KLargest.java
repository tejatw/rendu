import java.util.Arrays;
import java.util.Collections;

public class KLargest {

	public static void main(String args[]) {
		
		Integer numbers[] = {1, 30, 45, 6, 50, 9, 17, 26};
		
		String strings[] = {"a", "c", "x", "g", "f", "b"};
		
		int k = 3;
		
		//sortKNumbers(numbers, k);
		//bubbleSort(numbers);
		
		Arrays.sort(strings);//, Collections.reverseOrder());
//		System.out.print(strings.toString());
		for (int i = 0; i < strings.length; i++) {
			
			System.out.println(strings[i]);
		}
	}
	
	public static void sortKNumbers(Integer[] numbers, int k) {
		
		Arrays.sort(numbers, Collections.reverseOrder());
		
		for (int i = 0; i < k; i++) {
			
			System.out.println(numbers[i]);
		}
	}
	
	public static void bubbleSort(Integer[] numbers) {
		
		int temp;
		
		for (int i = 0; i < numbers.length; i++) {
			
			for (int j = 0; j < numbers.length - 1; j++) {
				
				if (numbers[j] < numbers[j+1]) {
					
					temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		for (int index = 0; index < numbers.length; index++)
			System.out.println(numbers[index]);
	}
}
