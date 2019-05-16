package datastructures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class ReverseLL {


//    @Data
//    @AllArgsConstructor
//    @RequiredArgsConstructor
//    @NoArgsConstructor
    public static class NodeLL{

        private int value;
        private NodeLL next;

    public NodeLL(){
        this.value = 0;
        this.next = null;
    }

        public NodeLL(int value) {

            this.value = value;
            this.next = null;
        }

        public NodeLL(int value, NodeLL next) {

            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public NodeLL getNext() {
            return next;
        }

        public void setNext(NodeLL next) {
            this.next = next;
        }
    }


    public static void main(String... args) {

        NodeLL n4 = new NodeLL(4);
        NodeLL n3 = new NodeLL(3, n4);
        NodeLL n2 = new NodeLL(2, n3);
        NodeLL n1 = new NodeLL(1, n2);

        NodeLL head = new NodeLL();

        head = n1;

        printLinkedList(head);

        NodeLL tail = new NodeLL();

        tail = getLinkedListTail(head);

        head = reverseLinkedList(head);

        printLinkedList(tail);
    }

    public static void printLinkedList(NodeLL head) {

        NodeLL printNode = head;

        while (printNode != null) {
            System.out.println(printNode.getValue());
            printNode = printNode.getNext();
        }
    }

    public static NodeLL reverseLinkedList(NodeLL head) {

        if (head.getNext() == null){

            return head;
        }

        NodeLL temp = reverseLinkedList(head.getNext());
        temp.setNext(head);
        head.setNext(null);

        return head;
    }

    public static NodeLL getLinkedListTail(NodeLL head) {

        NodeLL tempNode = head;

        while (tempNode.getNext() != null) {

            tempNode = tempNode.getNext();
        }

        return tempNode;
    }
}
