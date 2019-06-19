package algorithms;

public class RunLengthEncoding {

    public static void main(String... args) {

        String input = "aaaabbbccdddddaaa";

        encodedString(input);
    }

     static void encodedString(String input) {
        char[] inputChar = input.toCharArray();

        char currentChar = inputChar[0];

        int counter = 1;

        for (int charIndex = 1; charIndex < inputChar.length; charIndex++){

            if (currentChar == inputChar[charIndex]) {

                counter++;
            }
            else{

                System.out.print("" + currentChar + counter);
                counter = 1;
                currentChar = inputChar[charIndex];
            }

        }

        System.out.print("" + currentChar + counter);
    }
}
