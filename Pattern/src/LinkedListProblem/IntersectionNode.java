package LinkedListProblem;

import java.util.HashSet;
import java.util.Set;

public class IntersectionNode {

    /**
     * 执行耗时:1 ms,击败了98.74% 的Java用户 内存消耗:52.7 MB,击败了11.99% 的Java用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode indexA = headA, indexB = headB;
        while (indexA != null) {
            lengthA++;
            indexA = indexA.next;
        }
        while (indexB != null) {
            lengthB++;
            indexB = indexB.next;
        }
        if (lengthA > lengthB) {
            for (int i = 0; headA != null && i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; headB != null && i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 执行耗时:18 ms,击败了7.65% 的Java用户 内存消耗:52.7 MB,击败了11.04% 的Java用户
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        while (headA != null) {
            nodeSet.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (nodeSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 是节点对象是同一个，不是值比较！！！
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeERROR(ListNode headA, ListNode headB) {
        ListNode result = null;
        int lengthA = 0, lengthB = 0;
        ListNode preNodeA = null;
        while (headA != null) {
            ListNode next = headA.next;
            headA.next = preNodeA;
            preNodeA = headA;
            headA = next;
            lengthA++;
        }
        ListNode preNodeB = null;
        while (headB != null) {
            ListNode next = headB.next;
            headB.next = preNodeB;
            preNodeB = headB;
            headB = next;
            lengthB++;
        }
        int length = lengthA > lengthB ? lengthB : lengthA;
        for (int i = 0; i < length; i++) {
            if (preNodeA != null && preNodeB != null && preNodeA.val == preNodeB.val) {
                result = preNodeA;
                preNodeA = preNodeA.next;
                preNodeB = preNodeB.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(8, d);
        ListNode b = new ListNode(1, c);
        ListNode a = new ListNode(4, b);
        ListNode c1 = new ListNode(1, c);
        ListNode b1 = new ListNode(0, c1);
        ListNode a1 = new ListNode(5, b1);
        SinglyLinkedListII.showList(a);
        SinglyLinkedListII.showList(a1);
        ListNode t = (new IntersectionNode().getIntersectionNode(a, a1));
        System.out.println(t == null ? null : t.val);
    }
}
