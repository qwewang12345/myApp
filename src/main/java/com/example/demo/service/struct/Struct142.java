package com.example.demo.service.struct;

/**
 * @author gaonan1
 * @date 2021/8/25 9:39
 **/
public class Struct142 {

    class ListNode {
        int value;
        ListNode next;
    }

    public ListNode hasCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 相遇后，相遇点指针和头指针同时走，会走到环入口
                // 公式为（x+y）*2 = x + y + （y + z）* n
                // 当n为1时，x=z，不为1时，相遇点指针多转几圈
                while (fast != head) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
