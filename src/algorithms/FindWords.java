package algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWords {

    public static void main(String args[]) {

        String originalString = "This is my pen";

        Pattern firstPattern = Pattern.compile("is");
        Pattern secondPattern = Pattern.compile("my");

        Matcher firstPatternMatcher = firstPattern.matcher(originalString);
        Matcher secondPatternMatcher = secondPattern.matcher(originalString);


        if (firstPatternMatcher.find() && secondPatternMatcher.find()) {

            System.out.println(firstPatternMatcher.start(0) + " " + secondPatternMatcher.start(0));
        }

        System.out.println(secondPatternMatcher.find());

        List<String> splitStrings = Arrays.asList(originalString.split(" "));

//        System.out.println(splitStrings);

        System.out.println((splitStrings.indexOf("pen") + 1) + " " + (splitStrings.indexOf("is") + 1));

    }
}
