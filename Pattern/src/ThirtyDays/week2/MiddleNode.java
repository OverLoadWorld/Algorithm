package ThirtyDays.week2;

public class MiddleNode {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        System.out.println(middleNode(head1).val);
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 36.7 MB
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode index = head;
        int listLength = 1;
        while (index.next != null) {
            listLength++;
            index = index.next;
        }
        int middleCount = listLength / 2;
        int i = 0;
        while (i < middleCount) {
            head = head.next;
            i++;
        }
        return head;
    }
}
