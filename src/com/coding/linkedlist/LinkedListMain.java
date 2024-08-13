package com.coding.linkedlist;

public class LinkedListMain {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(22);
        head = head.reverseLL(head);
        head.print(head);
    }
}
