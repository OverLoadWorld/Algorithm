package LinkedListProblem;

public class SinglyLinkedListII {

    /**
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37 MB,击败了78.88% 的Java用户
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int reverseLength = n - m + 1;
        ListNode result = head;
        ListNode preNode = null;
        while (head != null && --m > 0) {
            preNode = head;
            head = head.next;
        }
        ListNode reverseTailNode = head;
        ListNode newHead = null;
        while (head != null && reverseLength-- > 0) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        if (preNode != null) {
            preNode.next = newHead;
        } else {
            result = newHead;
        }
        reverseTailNode.next = head;
        return result;
    }

    public static void main(String[] args) {
/*        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);*/

        ListNode c = new ListNode(3, null);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        showList(a);
        showList(new SinglyLinkedListII().reverseBetween(a, 3, 3));

    }

    public static void showList(ListNode head) {
        int i = 0;
        while (head != null) {
            if (i == 0) {
                System.out.print(head.val);
            } else {
                System.out.print("-->" + head.val);
            }
            i = 1;
            head = head.next;
        }
        System.out.println();
    }
}
