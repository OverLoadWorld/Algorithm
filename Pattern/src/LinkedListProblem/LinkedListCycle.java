package LinkedListProblem;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:39.5 MB,击败了69.31% 的Java用户
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 执行耗时:3 ms,击败了19.55% 的Java用户 内存消耗:40.1 MB,击败了21.70% 的Java用户
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode c = new ListNode(0);
//        ListNode b = new ListNode(2, c);
        ListNode d = new ListNode(-4);
        c.next = d;
        d.next = c;
//        ListNode a = new ListNode(3, b);
        System.out.println(new LinkedListCycle().hasCycle(c));
    }
}
