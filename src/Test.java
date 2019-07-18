import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String args[]) {

        // create an array of string objs
        String init[] = { "One", "Two", "Three", "One", "Two", "Three" };

        // create two lists
        List list1 = new ArrayList(Arrays.asList(init));
        List list2 = new ArrayList(Arrays.asList(init));

        // remove from list1
        list1.remove("One");
        System.out.println("List1 value: "+list1);

        // remove from list2 using singleton
        list2.removeAll(Collections.singleton("One"));
        System.out.println("The SingletonList is :"+list2);
    }
}
