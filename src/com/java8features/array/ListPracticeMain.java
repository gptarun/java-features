package com.java8features.array;

public class ListPracticeMain {
    static Node head;

    static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            next = null;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public Node reverse(Node node) {
        Node previous = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public static void main(String[] args) {
        ListPracticeMain list = new ListPracticeMain();
        list.head = new Node(5);
        list.head.next = new Node(10);
        list.head.next.next = new Node(20);
        list.printList(head);
        Node reverse = list.reverse(head);
        System.out.println("Reverse:");
        list.printList(reverse);
    }
}
