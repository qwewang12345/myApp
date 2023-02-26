package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct141 {

    class ListNode {
        int value;
        ListNode next;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
