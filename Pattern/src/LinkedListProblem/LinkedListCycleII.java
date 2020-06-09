package LinkedListProblem;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
     * Memory Usage: 39.5 MB, less than 67.88% of Java online submissions for Linked List Cycle II.
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //是否同时出发，决定了相遇位置，相遇位置，影响“ead 到 cycle 人口 = meet 到 cycle入口” 条件的成立
/*        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (slow == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }*/
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        //head 到 cycle 人口 = meet 到 cycle入口
        slow = head;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next;
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
/*        ListNode g = new ListNode(-1);
        ListNode f = new ListNode(1, g);
        ListNode e = new ListNode(5, f);
        ListNode d = new ListNode(-4, e);
        ListNode c = new ListNode(0, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(3, b);
        g.next = c;*/
        ListNode b = new ListNode(2);
        ListNode a = new ListNode(1, b);
        ListNode t = new LinkedListCycleII().detectCycle(a);
        System.out.println(t == null ? null : t.val);
    }
}
