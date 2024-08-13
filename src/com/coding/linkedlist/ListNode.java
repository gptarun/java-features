package com.coding.linkedlist;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public void print(ListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public ListNode reverseLL(ListNode node) {
        ListNode pre = null;
        ListNode current = node;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
