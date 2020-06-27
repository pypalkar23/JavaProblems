package leetcode;

public class OddEvenLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        if (head.next.next == null)
            return head;

        ListNode currPointer = head;
        ListNode evenHead = new ListNode();
        ListNode currEvenHead = evenHead;

        while(currPointer.next!=null){
            currEvenHead.next= currPointer.next;
            currEvenHead = currEvenHead.next;
            currPointer.next = currPointer.next.next;
            if(currPointer.next == null)
                break;
        }

        currPointer.next = evenHead.next;
        return head;
    }
}