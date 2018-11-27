package datastructures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

public class ReverseLinkedList {


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

        Node head  = new Node();
        head = n1;

        printLinkedList(head);

        Node tail = new Node();

        tail = findLinkedListTail(head);

        head = reverseLinkedList(head);

        printLinkedList(tail);


    }

    public static void printLinkedList(Node head) {

        Node n = head;

        while (n != null) {

            System.out.println(n.getData());
            n = n.getNext();
        }
    }

    public static Node reverseLinkedList(Node head) {

        if (head.getNext() == null) {

            return head;
        }

        Node temp = reverseLinkedList(head.getNext());
        temp.setNext(head);
        head.setNext(null);

        return head;


    }

    public static Node findLinkedListTail(Node head) {

        while (head.getNext() != null) {

            head = head.getNext();
        }

        return head;
    }
}
