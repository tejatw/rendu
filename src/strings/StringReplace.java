package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringReplace {

	public static void main (String args[]) {

		Integer[] spam = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.asList(spam).stream()
				.filter(number -> (number > 2 && number < 5))
				//.distinct()
				.collect(Collectors.toList()));


				
			
	}

	public static void testStrings(){

		String key1 = "data/testdataset1/input/performance/1/performance.csv";

		String key2 = null;

		String datasetname = "testdataset1";

		System.out.println(key1  + " " + key2);

		key2 = key1.replace("data/"+datasetname, datasetname);

		System.out.println(key1 + " " + key2);

		key2 = "archive/" + key2;

		System.out.println(key1 + " " + key2);
	}
	
}
