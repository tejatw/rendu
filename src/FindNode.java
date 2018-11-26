import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class FindNode {

    public static void main(String... args) {

        List<Integer> list1 = new ArrayList<>(Arrays.asList(7, 5, 9, 12));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 4, 8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 5, 6, 10));

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);

        Integer node1 = 5, node2 = 6;


        Map<Integer, List<Integer>> counterMap = new HashMap<>();

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        boolean firstListIsEmpty = false;
        boolean secondListIsEmpty = false;

        for( List<Integer> list : listOfLists){

            if (list.contains(node1) && firstListIsEmpty == false) {
                firstList = list;
                firstListIsEmpty = true;
            }
            else if (list.contains(node2) && secondListIsEmpty == false){
                secondList = list;
                secondListIsEmpty = true;
            }

        }

        for (Integer item : firstList) {

            if (secondList.contains(item)){

                System.out.println("Nodes are connected");
                System.exit(0);
            }

        }

        System.out.println("Nodes are not connected");

//        listOfLists.stream().forEach(list -> {
//
//            if (list.contains(node1))
//                firstList = list;
//
//        });

    }
}
