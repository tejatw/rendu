package datastructures;

import java.util.Collections;
import java.util.LinkedList;

public class TestLinkedList {



    public static void main(String args[]){

        /*//create node 1
        Node n1 = new Node(new Integer(1));
        Node n2 = new Node(new Integer(2));
        n1.setNext(n2);
        Node n3 = new Node(new Integer(3));
        n2.setNext(n3);

        System.out.println(n1.getNext().data);*/

        LinkedList<Node> listOfNodes = new LinkedList<>();

        listOfNodes.add(new Node(1));
        listOfNodes.add(new Node(3));
        listOfNodes.add(new Node(2));
        listOfNodes.add(new Node(5));
        listOfNodes.add(new Node(4));



        listOfNodes.stream().forEach(node -> System.out.print(node.getData() + " "));

        Collections.sort(listOfNodes);
        listOfNodes.stream().forEach(node -> System.out.print(node.getData() + " "));

        System.out.println();
        System.out.println(listOfNodes.contains(new Node(2)));
    }

    public static class Node implements Comparable<Node> {

        private Integer data;

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }


        Node(Integer data){

            this.data = data;

        }

        @Override
        public int compareTo(Node node){

            return (this.data - node.data);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    /*public static class Node {

        private Integer data;
        private Node next;

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node(Integer data){

            this.data = data;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }*/
}
