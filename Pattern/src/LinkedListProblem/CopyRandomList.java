package LinkedListProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: ZhaoZhenHua1 Administrator
 * @Date: 2020/6/9 17:23
 */
public class CopyRandomList {

    /**
     * Next pointer of node with label 7 from the original list was modified.
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node index = head;
        Node newHead = null;
        while (index != null) {
            Node newNode = new Node(index.val);
            newNode.next = index.next;
            index.next = newNode;
            if (index == head) {
                newHead = newNode;
            }
            index = index.next.next;
        }
        index = head;
        while (index != null) {
            index.next.random = index.random == null ? null : index.random.next;
            index = index.next.next;
        }

        index = head;
        while (index != null) {
            if (index.next != null) {
                index.next = index.next.next;
            }

            if (index.next.next != null) {
                index.next.next = index.next.next.next;
            }
            index = index.next.next;
        }

        index = newHead;
        while (index != null) {
            if (index.next != null) {
                index.next = index.next.next;
            }
            index = index.next;
        }
        return newHead;
    }

    /**
     * Runtime: 1 ms, faster than 15.63% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 42.9 MB, less than 8.21% of Java online submissions for Copy List with Random Pointer.
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = null;
        Node tempHead = head;
        Node tempPreHead = null;
        int index = 0;
        Map<Integer, Node> locationMap = new HashMap<>();
        while (tempHead != null) {
            Node newNode = new Node(tempHead.val);
            if (index == 0) {
                newHead = newNode;
            }
            if (index == 1) {
                newHead = tempPreHead;
            }
            locationMap.put(index++, newNode);

            if (tempPreHead != null) {
                tempPreHead.next = newNode;
            }
            tempPreHead = newNode;
            tempHead = tempHead.next;
        }
        tempHead = head;
        index = 0;
        while (tempHead != null) {
            tempHead.val = index++;
            tempHead = tempHead.next;
        }
        tempHead = newHead;
        while (head != null) {
            tempHead.random = head.random == null ? null : locationMap.get(head.random.val);
            head = head.next;
            tempHead = tempHead.next;
        }
        return newHead;
    }


    public static void main(String[] args) {
        /*Node e = new Node(1);
        Node d = new Node(10);
        Node c = new Node(11);
        Node b = new Node(13);
        Node a = new Node(7);
        a.next = b;
        a.random = null;
        b.next = c;
        b.random = a;
        c.next = d;
        c.random = e;
        d.next = e;
        d.random = c;
        e.next = null;
        e.random = a;*/
        Node a = new Node(-1);
        a.random = null;
        showNodeList(a);
        showNodeList(new CopyRandomList().copyRandomList(a));
    }

    public static void showNodeList(Node head) {
        int i = 0;
        while (head != null) {
            if (i == 0) {
                System.out.print("[" + head.val+","+ (head.random == null ? null : head.random.val) + "]");
            } else {
                System.out.print("-->" + "[" + head.val+","+ (head.random == null ? null : head.random.val) + "]");
            }
            i = 1;
            head = head.next;
        }
        System.out.println();
    }

}
