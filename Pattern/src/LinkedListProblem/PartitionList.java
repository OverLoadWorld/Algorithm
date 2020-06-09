package LinkedListProblem;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/9 14:51
 */
public class PartitionList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
     * Memory Usage: 38.5 MB, less than 98.91% of Java online submissions for Partition List.
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode before = null;
        ListNode beforeHead = null;
        ListNode beforeTail = null;
        ListNode after = null;
        ListNode afterHead = null;
        while (head != null) {
            if (head.val < x) {
                if (before == null) {
                    beforeHead = head;
                    before = head;
                } else {
                    before.next = head;
                    before = before.next;
                }
            } else {
                if (after == null) {
                    afterHead = head;
                    after = head;
                } else {
                    after.next = head;
                    after = after.next;
                }
            }
            head = head.next;
        }

        beforeTail = before;
        //中止之前的list关系
        if (after != null) {
            after.next = null;
        }

        if (beforeTail != null) {
            beforeTail.next = afterHead;
        } else {
            return afterHead;
        }
        return beforeHead;
    }

    public static void main(String[] args) {

/*        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(8, d);
        ListNode b = new ListNode(1, c);
        ListNode a = new ListNode(4, b);*/

        ListNode f = new ListNode(2);
        ListNode e = new ListNode(5, f);
        ListNode d = new ListNode(2, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(4, c);
        ListNode a = new ListNode(1, b);
        SinglyLinkedListII.showList(a);
        SinglyLinkedListII.showList(new PartitionList().partition(a, 6));
    }
}
