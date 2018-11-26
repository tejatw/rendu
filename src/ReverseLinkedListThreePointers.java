import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class ReverseLinkedListThreePointers {


    @Data
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class Node {

        private Integer data;
        private Node next;

        public Node(Integer data) {

            this.data = data;
            this.next = null;
        }

    }

    public static void main(String... args) {

        Node n4 = new Node(4);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        Node current = n1;

        printLinkedList(current);

        Node previous = null;
        Node future = null;



        //Comment 2
        while (current != null) {

            future = current.getNext();
            current.setNext(previous);
            previous = current;
            current = future;

        }

        printLinkedList(previous);


    }

    public static void printLinkedList(Node head) {

        Node n = head;

        while (n != null) {

            System.out.println(n.getData());
            n = n.getNext();
        }
    }


}
