package LinkedListProblem;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow != head) {
            slow = slow.next;
            head = head.next;
        }
        return slow;
    }

    /**
     * 相遇，但是不是环的起始位置
     * @param head
     * @return
     */
    public ListNode detectCycleERROR(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 执行耗时:3 ms,击败了25.03% 的Java用户 内存消耗:40.3 MB,击败了27.32% 的Java用户
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(0);
        ListNode b = new ListNode(2, c);
        ListNode d = new ListNode(-4, b);
        c.next = d;
        ListNode a = new ListNode(3, b);
        System.out.println(new LinkedListCycleII().detectCycle(a).val);
    }
}
