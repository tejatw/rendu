package javaconcepts;

import java.util.*;

public class TestStack {

    public static void main(String args[]){

        Stack<Integer> integerStack = new Stack<>();

        integerStack.push(new Integer(1));
        integerStack.push(2);
        integerStack.push(new Integer(3));
        integerStack.addAll(new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10)));

        System.out.println(integerStack.pop());
        System.out.println(integerStack.toString());

        integerStack.add(0, -1);
        System.out.println(integerStack.toString());

    }
}
