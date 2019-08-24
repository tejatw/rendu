import java.util.Scanner;

public class PrintPyramid {

    public static void  main(String... args){

        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();

        int totalTests = count;

        String[] pyramidString = new String[count];
        Integer[] pyramidSize = new Integer[count];
        Integer[] pyramidDirection = new Integer[count];

        Integer iterate = 0;

        while (iterate < count){

            pyramidString[iterate] = scan.next();
            pyramidSize[iterate] = scan.nextInt();
            pyramidDirection[iterate] = scan.nextInt();

            iterate += 1;

        }

        iterate = 0;

        while (iterate < count) {

            printPyramid(pyramidString[iterate], pyramidSize[iterate], pyramidDirection[iterate]);
            iterate += 1;
        }
    }

    public static void printPyramid(String pyramidString, Integer pyramidSize, Integer pyramidDirection) {

        Integer pyramidBaseLength = (2 * pyramidSize) - 1;

        char[] pyramidChars = pyramidString.toCharArray();

        Boolean reverseFlag = false;

        Integer countOfTotalCharacters = 0;

        if (pyramidDirection == 1) {

            for (int floor = 1; floor <= pyramidSize; floor++) {

                for (int i = 0; i <= (pyramidBaseLength/2 - floor); i++) {
                    System.out.print(" ");
                }
//            for (int j = 0; j < (2 * floor) -1; j++){

                String stringToBePrinted = returnSequence(pyramidChars, countOfTotalCharacters%pyramidChars.length, (2 * floor) - 1, reverseFlag);
                System.out.print(stringToBePrinted);
                countOfTotalCharacters += stringToBePrinted.length();

                reverseFlag = (reverseFlag == false) ? true : false;

//            }
                for (int k = pyramidBaseLength / 2; k <= pyramidBaseLength; k++) {
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        else{

            for (int floor = pyramidSize; floor >= 1; floor--) {

                for (int i = 0; i <= (pyramidBaseLength/2 - floor); i++) {
                    System.out.print(" ");
                }
//            for (int j = 0; j < (2 * floor) -1; j++){

                String stringToBePrinted = returnSequence(pyramidChars, countOfTotalCharacters%pyramidChars.length, (2 * floor) - 1, reverseFlag);
                System.out.print(stringToBePrinted);
                countOfTotalCharacters += stringToBePrinted.length();

                reverseFlag = (reverseFlag == false) ? true : false;

//            }
                for (int k = (pyramidBaseLength - (2 * floor)); k > 0; k--) {
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static String returnSequence(char[] inputString, Integer startingPosition, Integer length, Boolean reverseFlag) {

        Integer outputLength = 0;

        StringBuilder stringBuilder = new StringBuilder();

        while (outputLength++ < length) {

            stringBuilder.append(inputString[startingPosition]);

            startingPosition++;

            startingPosition = (startingPosition >= inputString.length) ? 0 : startingPosition;
        }

        if (reverseFlag == false)
            return stringBuilder.toString();
        else
            return stringBuilder.reverse().toString();
    }
}
