package LinkedListProblem;

public class MergeTwoSortedLinked {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.1 MB,击败了60.34% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsGuardNode(ListNode l1, ListNode l2) {
        ListNode guardNode = new ListNode(0);
        ListNode index = guardNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                index.next = l1;
                l1 = l1.next;
            } else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        while (l1 != null) {
            index.next = l1;
            l1 = l1.next;
            index = index.next;
        }

        while (l2 != null) {
            index.next = l2;
            l2 = l2.next;
            index = index.next;
        }

        return guardNode.next;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39 MB,击败了66.85% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode index = null;
        if (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                index = l1;
                l1 = l1.next;
            } else {
                index = l2;
                l2 = l2.next;
            }
        } else {
            if (l1 != null) {
                index = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                index = l2;
                l2 = l2.next;
            }
        }
        head = index;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                index.next = l1;
                l1 = l1.next;
            } else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }
        while (l1 != null) {
            index.next = l1;
            l1 = l1.next;
            index = index.next;
        }

        while (l2 != null) {
            index.next = l2;
            l2 = l2.next;
            index = index.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode c1 = new ListNode(4);
        ListNode b1 = new ListNode(3, c1);
        ListNode a1 = new ListNode(1, b1);

        ListNode c = new ListNode(4);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        SinglyLinkedListII.showList(a);
        SinglyLinkedListII.showList(a1);
        SinglyLinkedListII.showList(new MergeTwoSortedLinked().mergeTwoListsGuardNode(a, a1));
    }
}
