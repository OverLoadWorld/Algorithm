package LinkedListProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeKSortedLinkedLists {
    /**
     * 执行耗时:4 ms,击败了81.57% 的Java用户
     * 			内存消耗:45.1 MB,击败了5.02% 的Java用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoListsGuardNode(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] subListA = new ListNode[mid];
        ListNode[] subListB = new ListNode[lists.length - mid];
        for (int i = 0; i < mid; i++) {
            subListA[i] = lists[i];
        }
        for (int i = mid; i < lists.length; i++) {
            subListB[i - mid] = lists[i];
        }
        ListNode a = mergeKLists(subListA);
        ListNode b = mergeKLists(subListB);

        return mergeTwoListsGuardNode(a, b);
    }

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
     * 执行耗时:15 ms,击败了20.02% 的Java用户
     * 			内存消耗:45.2 MB,击败了5.02% 的Java用户
     *
     * lists == null ? 0 : lists.length * 10
     * 	执行耗时:17 ms,击败了19.43% 的Java用户
     * 			内存消耗:44.9 MB,击败了6.95% 的Java用户
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        List<ListNode> allNodeList = new ArrayList<>();//lists == null ? 0 : lists.length * 10
        for (ListNode list : lists) {
            ListNode head = list;
            while (head != null) {
                allNodeList.add(head);
                head = head.next;
            }
        }
        if (allNodeList == null || allNodeList.size() == 0) {
            return null;
        }
        allNodeList.sort((o1, o2) -> o1.val - o2.val);
        for (int i = 1; i < allNodeList.size(); i++) {
            allNodeList.get(i - 1).next = allNodeList.get(i);
        }
        allNodeList.get(allNodeList.size() - 1).next = null;

        return allNodeList.get(0);
    }

    public static void main(String[] args) {
        ListNode c1 = new ListNode(4);
        ListNode b1 = new ListNode(3, c1);
        ListNode a1 = new ListNode(1, b1);

        ListNode c = new ListNode(4);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        ListNode d2 = new ListNode(122);
        ListNode c2 = new ListNode(15,d2);
        ListNode b2 = new ListNode(9, c2);
        ListNode a2 = new ListNode(0, b2);
        SinglyLinkedListII.showList(a);
        SinglyLinkedListII.showList(a1);
        SinglyLinkedListII.showList(a2);
//        ListNode a = null;
//        ListNode[] lists = new ListNode[]{a, a1, a2};
        ListNode[] lists = new ListNode[]{};
        SinglyLinkedListII.showList(new MergeKSortedLinkedLists().mergeKLists(lists));
    }
}
