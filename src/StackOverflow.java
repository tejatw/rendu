public class StackOverflow {

    public static void main(String... args) {

        int i = 0;
        recursionFunction(i);

    }

    static void recursionFunction(int i) {

        System.out.println("Count of i is " + i);
        recursionFunction(i+1);
    }
}
